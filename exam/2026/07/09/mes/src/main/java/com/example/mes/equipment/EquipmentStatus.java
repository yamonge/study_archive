package com.example.mes.equipment;

import lombok.Data;

@Data
public class EquipmentStatus {

    private String equipmentId;
    private String state;
    private String message;
}