package com.ex.spring_jap_board.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class CustomException extends RuntimeException{
    private final HttpStatus status;
    private final String message;

    public CustomException(HttpStatus status, String message){
        super(message);
        this.status = status;
        this.message = message;
    }
}
