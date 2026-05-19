package com.ex.spring_jap_board.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;

    @Column(nullable = false, length = 50)
    private String commentWriter;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String commentContent;

    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board board;

    @Column(columnDefinition = "boolean default false")
    private boolean commentDeleted;

    private LocalDateTime commentCreatedAt;

    @PrePersist
    public void prePersist(){
        this.commentCreatedAt = LocalDateTime.now();
    }
}
