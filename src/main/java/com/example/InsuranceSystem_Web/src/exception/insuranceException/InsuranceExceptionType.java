package com.example.InsuranceSystem_Web.src.exception.insuranceException;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum InsuranceExceptionType {

    EMPTY_INSURANCE(300, HttpStatus.BAD_REQUEST, "목록에 있는 번호를 입력해 주세요.");

    private final int code;
    private final org.springframework.http.HttpStatus httpStatus;
    private final String message;
}
