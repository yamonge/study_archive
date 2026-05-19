package com.ex.spring_jap_board.entity;

import com.ex.spring_jap_board.constant.ProductCategory;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    @Column(nullable = false, length = 100)
    private String productName;

    @Column(columnDefinition = "TEXT")
    private String productDesc;

    @Column(nullable = false)
    private int productPrice;

    @Column(nullable = false)
    private int stock = 0;

    @Column(length = 255)
    private String productImage;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ProductCategory productCategory = ProductCategory.ETC;

    private LocalDateTime productCreatedAt;

    @PrePersist
    public void prePersist(){
        this.productCreatedAt = LocalDateTime.now();
    }
}
