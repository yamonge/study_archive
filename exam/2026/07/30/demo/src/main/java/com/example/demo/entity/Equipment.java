package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "equipment")
public class Equipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(
            name = "equipment_code",
            nullable = false,
            unique = true,
            length = 30
    )
    private String equipmentCode;

    @Column(
            name = "equipment_name",
            nullable = false,
            length = 100
    )
    private String equipmentName;

    @Column(nullable = false, length = 20)
    private String status;

    public Equipment() {
    }

    public Equipment(
            String equipmentCode,
            String equipmentName,
            String status
    ) {
        this.equipmentCode = equipmentCode;
        this.equipmentName = equipmentName;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public String getEquipmentCode() {
        return equipmentCode;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public String getStatus() {
        return status;
    }

    public void setEquipmentCode(String equipmentCode) {
        this.equipmentCode = equipmentCode;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}