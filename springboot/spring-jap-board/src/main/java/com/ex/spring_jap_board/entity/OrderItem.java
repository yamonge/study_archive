package com.ex.spring_jap_board.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
public class OrderItem {
    // order_item_id pk
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderItemId;
    // N:1 연관 관계 매핑, 한개의 아이템은 주문서 내에 여러 아이템으로 사용 될수 있음
    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;
    // N:1 한개의 주문서에 여러개의 주문 아이템이 존재
    @ManyToOne
    @JoinColumn(name = "orders_id")
    private Orders orders;
    // 주문 가격
    private int orderPrice;

    // 주문 개수
    private int quantity;
    // 등록일 수정일
    private LocalDateTime orderItemCreatedAt;
    private LocalDateTime orderItemUpdatedAt;

    @PrePersist
    public void prePersist(){
        this.orderItemCreatedAt = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate(){
        this.orderItemUpdatedAt = LocalDateTime.now();
    }

}
