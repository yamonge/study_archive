package com.ex.spring_jap_board.websocket;

import com.ex.spring_jap_board.dto.response.ChatMessageRes;
import com.ex.spring_jap_board.exception.CustomException;
import com.ex.spring_jap_board.security.JwtUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@Component
public class ChatWebSocketHandler extends TextWebSocketHandler {

    private final Map<String, WebSocketSession> sessions = new ConcurrentHashMap<>();

    private final Map<Long, Set<String>> roomSessions = new ConcurrentHashMap<>();

    private final ObjectMapper objectMapper = new ObjectMapper();

    private final JwtUtil jwtUtil = new JwtUtil();

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        sessions.put(session.getId(), session);

        log.info("웹소켓 연결 성공 sessionId={}", session.getId());
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String payload = message.getPayload();

        SocketMessage req = objectMapper.readValue(
                payload,
                SocketMessage.class
        );

        if("WATCH".equals(req.getType())){
            roomSessions.putIfAbsent(
                    req.getRoomId(),
                    ConcurrentHashMap.newKeySet()
            );

            roomSessions.get(req.getRoomId())
                    .add(session.getId());

            return;
        }

        if("CHAT".equals(req.getType())){
            String token = req.getAccessToken();

            if (token == null || !jwtUtil.validateToken(token)) {
                throw new CustomException(HttpStatus.UNAUTHORIZED, "로그인이 필요합니다");
            }

            Long memberId = jwtUtil.getMemberId(req.getAccessToken());

            Set<String> sessionIds = roomSessions.get(req.getRoomId());

            if(sessionIds == null){
                return;
            }

            ChatMessageRes res =
                    ChatMessageRes.builder()
                            .memberId(memberId)
                            .message(req.getMessage())
                            .createdAt(LocalDateTime.now())
                            .build();

            String responsePayload = objectMapper.writeValueAsString(res);

            for(String sessionId : sessionIds){
                WebSocketSession targetSession = sessions.get(sessionId);

                if(targetSession != null && targetSession.isOpen()){
                    targetSession.sendMessage(
                            new TextMessage(responsePayload)
                    );
                }
            }
            return;
        }
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        sessions.remove(session.getId());

        log.info("웹소켓 연결 종료 sessionId={}, status={}",
                session.getId(),
                status);
    }
}
