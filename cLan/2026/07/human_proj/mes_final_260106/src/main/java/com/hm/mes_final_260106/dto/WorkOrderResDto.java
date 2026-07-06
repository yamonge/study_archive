package com.hm.mes_final_260106.dto;

import com.hm.mes_final_260106.entity.WorkOrder;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class WorkOrderResDto {
    private Long id;
    private String productCode;
    private int targetQty;
    private int currentQty;
    private String status;
    private LocalDateTime orderDate;

    public static WorkOrderResDto fromEntity(WorkOrder entity) {
        return WorkOrderResDto.builder()
                .id(entity.getId())
                .productCode(entity.getProductCode())
                .targetQty(entity.getTargetQty())
                .currentQty(entity.getCurrentQty())
                .status(entity.getStatus())
                .orderDate(entity.getCreatedAt())
                .build();
    }
}
