package com.ex.spring_jap_board.websocket;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SocketMessage {
    private String type;
    private Long roomId;
    private String message;
    private String accessToken;
}
