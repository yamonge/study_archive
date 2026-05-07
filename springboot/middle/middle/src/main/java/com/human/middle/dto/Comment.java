package com.human.middle.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Comment {
    private Long commentId;
    private String content;
    private Long boardId;
    private Long memberId;
    private LocalDateTime createAt;
}