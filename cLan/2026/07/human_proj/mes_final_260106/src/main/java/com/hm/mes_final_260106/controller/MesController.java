package com.hm.mes_final_260106.controller;

import com.hm.mes_final_260106.dto.*;
import com.hm.mes_final_260106.entity.Material;
import com.hm.mes_final_260106.entity.WorkOrder;
import com.hm.mes_final_260106.service.ProductionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mes")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@Slf4j
public class MesController {
    private final ProductionService productionService;

    // --- Web Dashboard API ---
    @PostMapping("/material/inbound")
    public ResponseEntity<Material> inboundMaterial(@RequestBody MaterialInboundDto dto) {
        log.info("자재 입고 : {}", dto);
        return ResponseEntity.ok(productionService.inboundMaterial(dto.getCode(), dto.getName(), dto.getAmount()));
    }

    @GetMapping("/material/stock")
    public ResponseEntity<List<Material>> getMaterialStock() {
        return ResponseEntity.ok(productionService.getMaterialStock());
    }

    @PostMapping("/order")
    public ResponseEntity<WorkOrderResDto> createOrder(@RequestBody WorkOrderReqDto dto) {
        log.info("작업 지시 생성 : {}", dto);
        WorkOrder order = productionService.createWorkOrder(dto.getProductCode(), dto.getTargetQty());
        return ResponseEntity.ok(WorkOrderResDto.fromEntity(order));
    }

    @GetMapping("/orders")
    public ResponseEntity<List<WorkOrderResDto>> getAllOrders() {
        return ResponseEntity.ok(productionService.getAllWorkOrders().stream()
                .map(WorkOrderResDto::fromEntity).toList());
    }

    // --- Machine API (인증 없음: L2 수집기가 바로 호출) ---
    @GetMapping("/machine/poll")
    public ResponseEntity<WorkOrderResDto> pollWork(@RequestParam String machineId) {
        log.info("설비 폴링 요청 : {}", machineId);
        WorkOrder work = productionService.assignWorkToMachine(machineId);
        return (work != null) ? ResponseEntity.ok(WorkOrderResDto.fromEntity(work))
                : ResponseEntity.noContent().build();
    }

    @PostMapping("/machine/report")
    public ResponseEntity<String> reportProduction(@RequestBody ProductionReportDto dto) {
        productionService.reportProduction(dto.getOrderId(), dto.getMachineId(),
                dto.getResult(), dto.getDefectCode(), dto.getSerialNo());
        return ResponseEntity.ok("ACK");
    }

    @GetMapping("/production/recent-logs")
    public ResponseEntity<List<RecentLogDto>> getRecentLogs() {
        return ResponseEntity.ok(productionService.getRecentLogs());
    }
}