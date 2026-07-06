package com.hm.mes_final_260106.dto;

import lombok.Data;

@Data
public class ProductionReportDto {
    private Long orderId;
    private String machineId;
    private String result;
    private String defectCode;
    private String serialNo;
}
