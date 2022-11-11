package com.example.InsuranceSystem_Web.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public class BaseException extends RuntimeException{

    private final int code;
    private final HttpStatus httpStatus;

    public BaseException(int code, HttpStatus httpStatus, String message){
        super(message);
        this.code = code;
        this.httpStatus = httpStatus;
    }

}
