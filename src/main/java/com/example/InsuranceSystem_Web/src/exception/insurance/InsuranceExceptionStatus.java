package com.example.InsuranceSystem_Web.src.exception.insurance;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum InsuranceExceptionStatus {
    EMPTY_INSURANCE(1000, HttpStatus.BAD_REQUEST, "존재하지 않는 보험입니다.");

    private final int code;
    private final org.springframework.http.HttpStatus httpStatus;
    private final String message;
}
