package com.example.InsuranceSystem_Web.config;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum BaseResponseStatus {
    SUCCESS(1000, HttpStatus.ACCEPTED, "요청에 성공하였습니다."),

    // common
    RUN_TIME_EXCEPTION(500,HttpStatus.INTERNAL_SERVER_ERROR, "런타임 에러"),
    NOT_FOUND_EXCEPTION(404,HttpStatus.NOT_FOUND, "요청한 리소스가 존재하지 않습니다."),
    INVALID_TYPE_VALUE_EXCEPTION(400,HttpStatus.BAD_REQUEST,  "유효하지 않는 Type의 값입니다. 입력 값을 확인 해주세요."),
    INVALID_FORMAT_EXCEPTION(400, HttpStatus.BAD_REQUEST, "유효하지 않는 Type 입니다. Type을 확인 해주세요."),
    INVALID_INPUT_VALUE_EXCEPTION(400, HttpStatus.BAD_REQUEST, "유효하지 않는 입력 값입니다."),
    METHOD_NOT_SUPPORT_EXCEPTION(405, HttpStatus.METHOD_NOT_ALLOWED, "지원하지 않은 HTTP Method 입니다."),
    ENTITY_NOT_FOUND_EXCEPTION(500, HttpStatus.INTERNAL_SERVER_ERROR, "해당 엔티티가 존재하지 않습니다."),


    REQUEST_ERROR(2000, HttpStatus.BAD_REQUEST, "입력값을 확인해주세요.");

    private final int code;
    private final org.springframework.http.HttpStatus httpStatus;
    private final String message;

}
