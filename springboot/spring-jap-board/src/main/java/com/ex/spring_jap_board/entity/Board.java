package com.ex.spring_jap_board.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Table(name = "board")
@Setter
@Getter
@ToString
public class Board {
    @Id
    @Column(name = "board_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardId;

    @Column(nullable = false, length = 200, name = "board_title")
    private String boardTitle;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String boardContent;

    @Column(nullable = false, length = 50)
    private String boardWriter;

    @Column(columnDefinition = "int default 0")
    private int boardViewCount;

    @Column()
    private LocalDateTime boardCreatedAt;

    @Column()
    private LocalDateTime boardUpdatedAt;

    @PrePersist
    public void prePersist(){
        this.boardCreatedAt = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate(){
        this.boardUpdatedAt = LocalDateTime.now();
    }
}
