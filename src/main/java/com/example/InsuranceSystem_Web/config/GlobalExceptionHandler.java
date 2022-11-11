package com.example.InsuranceSystem_Web.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(annotations = RestController.class)
public class GlobalExceptionHandler {

    @ExceptionHandler(BaseException.class)
    public ResponseEntity<BaseResponse> handleBaseException(BaseException exception) {
        int errorCode = exception.getCode();
        HttpStatus httpStatus = exception.getHttpStatus();
        String message = exception.getMessage();
        return ResponseEntity
                .status(exception.getHttpStatus())
                .body(new BaseResponse(errorCode,httpStatus,message));
    }

}
