package com.ex.spring_jap_board.entity;

import com.ex.spring_jap_board.constant.OrderStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.engine.internal.Cascade;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@ToString
public class Orders {
    // order_id PK
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ordersId;
    // N:1 회원관계 매핑
    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(mappedBy = "orders", cascade = CascadeType.ALL)
    private List<OrderItem> orderItemList = new ArrayList<>();
    // enum 타입으로 주문 상태
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;
    // 등록일, 수정일
    private LocalDateTime orderCreatedAt;
    private LocalDateTime orderUpdatedAt;

    @PrePersist
    public void prePersist(){
        this.orderCreatedAt = LocalDateTime.now();
        this.orderStatus = OrderStatus.ORDER;
    }

    @PreUpdate
    public void preUpdate(){
        this.orderUpdatedAt = LocalDateTime.now();
    }


}
