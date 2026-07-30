package com.example.demo.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "production_log")
public class ProductionLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "equipment_id",
            nullable = false
    )
    private Equipment equipment;

    @Column(name = "production_count", nullable = false)
    private int productionCount;

    @Column(name = "defect_count", nullable = false)
    private int defectCount;

    @Column(name = "recorded_at", nullable = false)
    private LocalDateTime recordedAt;

    public ProductionLog() {
    }

    public ProductionLog(
            Equipment equipment,
            int productionCount,
            int defectCount,
            LocalDateTime recordedAt
    ) {
        this.equipment = equipment;
        this.productionCount = productionCount;
        this.defectCount = defectCount;
        this.recordedAt = recordedAt;
    }

    public Long getId() {
        return id;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public int getProductionCount() {
        return productionCount;
    }

    public int getDefectCount() {
        return defectCount;
    }

    public LocalDateTime getRecordedAt() {
        return recordedAt;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public void setProductionCount(int productionCount) {
        this.productionCount = productionCount;
    }

    public void setDefectCount(int defectCount) {
        this.defectCount = defectCount;
    }

    public void setRecordedAt(LocalDateTime recordedAt) {
        this.recordedAt = recordedAt;
    }
}