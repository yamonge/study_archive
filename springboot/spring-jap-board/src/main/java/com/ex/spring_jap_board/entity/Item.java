package com.ex.spring_jap_board.entity;

import com.ex.spring_jap_board.constant.ItemSellStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemId;

    @Column(nullable = false, length = 50)
    private String itemName;

    @Column(nullable = false)
    private int itemPrice;

    @Column(nullable = false)
    private int itemStockNumber;

    @Lob
    @Column(nullable = false)
    private String itemDetail;

    @Enumerated(EnumType.STRING)
    private ItemSellStatus itemSellStatus;

    private LocalDateTime itemRegTime;
    private LocalDateTime itemUpdateTime;

    @PrePersist
    public void prePersist(){
        this.itemRegTime = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate(){
        this.itemUpdateTime = LocalDateTime.now();
    }
}
