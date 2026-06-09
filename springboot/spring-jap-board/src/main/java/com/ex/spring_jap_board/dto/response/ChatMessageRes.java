package com.ex.spring_jap_board.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Builder
public class ChatMessageRes {

    private Long memberId;

    private String nickname;

    private String message;

    private LocalDateTime createdAt;
}
