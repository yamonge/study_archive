package com.hm.mes_final_260106.service;

import com.hm.mes_final_260106.dto.RecentLogDto;
import com.hm.mes_final_260106.entity.*;
import com.hm.mes_final_260106.exception.CustomException;
import com.hm.mes_final_260106.repository.*;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductionService {
    private final ProductionLogRepository logRepo;
    private final MaterialRepository matRepo;
    private final WorkOrderRepository orderRepo;
    private final BomRepository bomRepo;

    // 자재 입고
    @Transactional
    public Material inboundMaterial(String code, String name, int amount) {
        Material material = matRepo.findByCode(code)
                .orElse(Material.builder().code(code).name(name).currentStock(0).build());
        material.setCurrentStock(material.getCurrentStock() + amount);
        return matRepo.save(material);
    }

    // 작업 지시 생성
    @Transactional
    public WorkOrder createWorkOrder(String productCode, int targetQty) {
        WorkOrder order = WorkOrder.builder()
                .productCode(productCode).targetQty(targetQty).currentQty(0).status("WAITING").build();
        return orderRepo.save(order);
    }

    // 설비 작업 할당 (L2 폴링 대응)
    @Transactional
    public WorkOrder assignWorkToMachine(String machineId) {
        return orderRepo.findByStatusAndAssignedMachineId("IN_PROGRESS", machineId)
                .orElseGet(() -> {
                    WorkOrder waiting = orderRepo.findFirstByStatusOrderByIdAsc("WAITING").orElse(null);
                    if (waiting != null) {
                        if (!isMaterialAvailable(waiting.getProductCode())) {
                            log.warn("[할당 보류] {} - 자재 부족으로 할당하지 않음", waiting.getProductCode());
                            return null;
                        }
                        waiting.setStatus("IN_PROGRESS");
                        waiting.setAssignedMachineId(machineId);
                        return orderRepo.save(waiting);
                    }
                    return null;
                });
    }

    // 생산 실적 보고 (JWT/SecurityContext 의존성 제거)
    @Transactional
    public void reportProduction(Long orderId, String machineId, String result, String defectCode, String serialNo) {
        WorkOrder order = orderRepo.findById(orderId)
                .orElseThrow(() -> new RuntimeException("작업 지시를 찾을 수 없습니다. ID: " + orderId));

        if ("COMPLETED".equals(order.getStatus())) return;

        // 생산 이력 저장 (5M1E 중 Man 제외한 나머지 축)
        logRepo.save(ProductionLog.builder()
                .workOrder(order)
                .productCode(order.getProductCode())
                .machineId(machineId)
                .serialNo(serialNo)
                .result(result)
                .defectCode("NG".equals(result) ? defectCode : null)
                .productAt(LocalDateTime.now())
                .build());

        // 자재 차감 (Backflushing) - 양품일 때만
        if ("OK".equals(result)) {
            List<Bom> boms = bomRepo.findAllByProductCode(order.getProductCode());
            for (Bom bom : boms) {
                Material mat = bom.getMaterial();
                int required = bom.getRequiredQty();
                int current = mat.getCurrentStock();

                if (current < required) {
                    throw new CustomException("SHORTAGE", "MATERIAL_SHORTAGE:" + mat.getName());
                }
                mat.setCurrentStock(current - required);
                log.info("[Backflushing] 자재: {}, 차감후 재고: {}", mat.getName(), mat.getCurrentStock());
            }
        } else {
            log.info("생산 불량 - 자재 차감 하지 않음");
        }

        order.setCurrentQty(order.getCurrentQty() + 1);
        if (order.getCurrentQty() >= order.getTargetQty()) {
            order.setStatus("COMPLETED");
        }

        log.info("[생산보고] {} - 수량: {}/{}", order.getProductCode(), order.getCurrentQty(), order.getTargetQty());
    }

    public List<WorkOrder> getAllWorkOrders() { return orderRepo.findAllByOrderByIdDesc(); }
    public List<Material> getMaterialStock() { return matRepo.findAll(); }

    private boolean isMaterialAvailable(String productCode) {
        List<Bom> boms = bomRepo.findAllByProductCode(productCode);
        for (Bom bom : boms) {
            if (bom.getMaterial().getCurrentStock() < bom.getRequiredQty()) {
                log.error("자재 부족: {} (현재: {}, 필요: {})",
                        bom.getMaterial().getName(), bom.getMaterial().getCurrentStock(), bom.getRequiredQty());
                return false;
            }
        }
        return true;
    }

    // 최근 생산 15건 (operatorName 제거)
    public List<RecentLogDto> getRecentLogs() {
        return logRepo.findTop15ByOrderByIdDesc().stream()
                .map(l -> new RecentLogDto(
                        l.getId(), l.getSerialNo(), l.getResult(), l.getMachineId(), l.getProductAt()))
                .collect(Collectors.toList());
    }
}