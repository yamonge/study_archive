package com.ex.spring_jap_board.exception;

// 모든 컨트롤러에서 발생한 예외를 한곳에서 처리 하도록 함

import com.ex.spring_jap_board.dto.response.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;

@Slf4j
@RestControllerAdvice // 모든 @RestController의 적용 하도록 하는 어노테이션
public class GlobalExceptionHandler {
    // 서비스 레이어에서 직접 던지는 비즈니스 예외 처리
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ApiResponse<Void>> handleCustomException(CustomException e){
        log.warn("CustomException: {}", e.getMessage());
        return ResponseEntity.status(e.getStatus())
                .body(ApiResponse.fail(e.getMessage()));
    }

    //@Valid 검증 처리
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<Void>> handleValidation(MethodArgumentNotValidException e){
        String msg = e.getBindingResult().getFieldErrors().stream()
                .map(FieldError::getDefaultMessage)
                .collect(Collectors.joining(", "));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ApiResponse.fail(msg));
    }

    // 3. 예상치 못한 에러
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<Void>> handleException(Exception e){
        log.error("Unhandled Exception : ", e);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ApiResponse.fail("서버 내부 오류가 발생했습니다"));
    }
}
