package com.human.backend.service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.charset.StandardCharsets;

@Service
public class DriverService {

    @Value("${driver.path}")
    private String driverPath;

    private Process process;
    private BufferedWriter toDriver;
    private BufferedReader fromDriver;

    @PostConstruct
    public void start() throws IOException {
        ProcessBuilder processBuilder = new ProcessBuilder(driverPath);

        // C 프로그램의 에러 출력은 Spring 실행 터미널에 표시
        // 정상 출력과 합치면 통신 결과가 섞일 수 있으므로 합치지 않음
        processBuilder.redirectError(ProcessBuilder.Redirect.INHERIT);

        process = processBuilder.start();

        // Spring → C 표준입력
        toDriver = new BufferedWriter(
                new OutputStreamWriter(
                        process.getOutputStream(),
                        StandardCharsets.UTF_8
                )
        );

        // C 표준출력 → Spring
        fromDriver = new BufferedReader(
                new InputStreamReader(
                        process.getInputStream(),
                        StandardCharsets.UTF_8
                )
        );
    }

    public synchronized String send(String command) throws IOException {
        if (process == null || !process.isAlive()) {
            throw new IOException("C 드라이버가 실행 중이 아닙니다.");
        }

        // C 프로그램에 명령 전송
        toDriver.write(command);
        toDriver.newLine();
        toDriver.flush();

        // C 프로그램 결과 한 줄 읽기
        String response = fromDriver.readLine();

        if (response == null) {
            throw new IOException("C 드라이버에서 응답을 받지 못했습니다.");
        }

        return response;
    }

    @PreDestroy
    public void stop() throws IOException {
        if (toDriver != null) {
            toDriver.close();
        }

        if (fromDriver != null) {
            fromDriver.close();
        }

        if (process != null && process.isAlive()) {
            process.destroy();
        }
    }
}