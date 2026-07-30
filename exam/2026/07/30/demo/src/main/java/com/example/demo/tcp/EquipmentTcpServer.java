package com.example.demo.tcp;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

@Component
public class EquipmentTcpServer {

    private static final int TCP_PORT = 5000;

    @PostConstruct
    public void startServer() {
        Thread serverThread = new Thread(this::runServer);

        // Spring Boot 종료 시 함께 종료될 수 있도록 설정
        serverThread.setDaemon(true);
        serverThread.start();
    }

    private void runServer() {
        try (ServerSocket serverSocket = new ServerSocket(TCP_PORT)) {

            System.out.println(
                    "[TCP 서버] 시작 완료 - 포트: " + TCP_PORT
            );

            while (true) {
                Socket clientSocket = serverSocket.accept();

                System.out.println(
                        "[TCP 서버] 에이전트 연결: "
                                + clientSocket.getInetAddress()
                );

                processClient(clientSocket);
            }

        } catch (Exception e) {
            System.err.println(
                    "[TCP 서버] 실행 오류: " + e.getMessage()
            );
        }
    }

    private void processClient(Socket clientSocket) {
        try (
                clientSocket;
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(
                                clientSocket.getInputStream(),
                                StandardCharsets.UTF_8
                        )
                );
                PrintWriter writer = new PrintWriter(
                        clientSocket.getOutputStream(),
                        true,
                        StandardCharsets.UTF_8
                )
        ) {
            String message;

            while ((message = reader.readLine()) != null) {
                System.out.println("[TCP 서버] 수신: " + message);

                String[] fields = message.split("\\|");

                if (fields.length != 5) {
                    writer.println("ERROR|INVALID_FORMAT");
                    continue;
                }

                String messageType = fields[0];
                String equipmentId = fields[1];
                String status = fields[2];
                int productionCount = Integer.parseInt(fields[3]);
                String timestamp = fields[4];

                System.out.println("메시지 종류: " + messageType);
                System.out.println("설비 ID: " + equipmentId);
                System.out.println("설비 상태: " + status);
                System.out.println("생산량: " + productionCount);
                System.out.println("전송시간: " + timestamp);

                writer.println("ACK|" + equipmentId);

                System.out.println(
                        "[TCP 서버] 응답 전송: ACK|" + equipmentId
                );
            }

            System.out.println("[TCP 서버] 에이전트 연결 종료");

        } catch (Exception e) {
            System.err.println(
                    "[TCP 서버] 클라이언트 처리 오류: "
                            + e.getMessage()
            );
        }
    }
}