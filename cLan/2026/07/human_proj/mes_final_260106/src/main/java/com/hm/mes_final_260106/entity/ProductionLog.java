package com.hm.mes_final_260106.entity;
// 생산 이력 : 5M1E의 집약체 (이번 버전은 Man 축 제외)

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class ProductionLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private WorkOrder workOrder;

    private String productCode;
    private String machineId;      // Machine 축

    @Column(unique = true)
    private String serialNo;       // 추적성(Traceability)

    private String result;         // Measurement 축 (OK/NG)
    private String defectCode;

    private LocalDateTime productAt; // Environment 축 (시간)
}