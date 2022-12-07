package com.example.InsuranceSystem_Web.src.exception.contract;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ContractExceptionStatus {

    // contract
    NOT_FOUND_CONTRACT(2000, HttpStatus.BAD_REQUEST, "존재하지 않는 계약입니다."),

    // customer
    NOT_FOUND_CUSTOMER(2001, HttpStatus.BAD_REQUEST, "등록된 고객 정보가 없습니다. 다시 시도해주시거나 회원 가입 후 진행해주세요."),
    WRONG_JOIN_CUSTOMER(2002, HttpStatus.BAD_REQUEST, "가입에 실패하였습니다. 다시 시도해주세요."),
    WRONG_TYPE_INPUT(2003, HttpStatus.BAD_REQUEST, "아이디는 숫자만 입력해 주세요.");

    private final int code;
    private final HttpStatus httpStatus;
    private final String message;
}
