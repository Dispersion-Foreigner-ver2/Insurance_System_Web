package com.example.InsuranceSystem_Web.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;

import static com.example.InsuranceSystem_Web.config.BaseResponseStatus.SUCCESS;


@Getter
@AllArgsConstructor
@JsonPropertyOrder({"code", "httpStatus", "message", "result"})
public class BaseResponse<T> {

    private final int code;
    private final HttpStatus httpStatus;
    private final String message;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T result;

    // 요청 성공
    public BaseResponse(T result){
        this.code = SUCCESS.getCode();
        this.httpStatus = SUCCESS.getHttpStatus();
        this.message = SUCCESS.getMessage();
        this.result = result;
    }

    public BaseResponse(BaseException e){
        this.code = e.getCode();
        this.httpStatus = e.getHttpStatus();
        this.message = e.getMessage();
    }

    // 요청 실패
    public BaseResponse(int code, HttpStatus httpStatus, String message){
        this.code = code;
        this.httpStatus = httpStatus;
        this.message = message;
    }
}
