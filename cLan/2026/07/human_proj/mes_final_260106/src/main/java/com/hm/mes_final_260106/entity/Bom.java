package com.hm.mes_final_260106.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @NoArgsConstructor @AllArgsConstructor @Builder
public class Bom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String productCode;

    @ManyToOne
    private Material material;
    private int requiredQty;
}