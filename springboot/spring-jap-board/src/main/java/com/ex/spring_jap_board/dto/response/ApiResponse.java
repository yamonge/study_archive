package com.ex.spring_jap_board.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ApiResponse<T> {
    private boolean success;
    private String message;
    private T data;

    // 성공 응답 데이터
    public static <T> ApiResponse<T> ok (T data){
        return new ApiResponse<>(true, "OK", data);
    }

    // 성공 응답 메세지 + 데이터
    public static <T> ApiResponse<T> ok (String message, T data){
        return new ApiResponse<>(true, message, data);
    }

    // 실패 응답
    public static <T> ApiResponse<T> fail(String message){
        return new ApiResponse<>(false, message, null);
    }
}
