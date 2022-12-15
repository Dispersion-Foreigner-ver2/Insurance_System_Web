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
    WRONG_TYPE_INPUT(2003, HttpStatus.BAD_REQUEST, "아이디는 숫자만 입력해 주세요."),
    FAILED_CONTRACT_SAVE(2004, HttpStatus.BAD_REQUEST, "예기치 못한 오류로 보험 계약에 실패하였습니다. 계약을 다시 시도해주세요."),
    EMPTY_CUSTOMER_CONTRACT(2005, HttpStatus.BAD_REQUEST, "해당 고객이 계약을 한 보험이 없습니다."),

    INPUT_NUM_ERROR(2006, HttpStatus.BAD_REQUEST, "숫자만 입력해 주세요."),
    INPUT_NULL(2007, HttpStatus.BAD_REQUEST, "공백입니다. 다시 입력해주세요."),;

    private final int code;
    private final HttpStatus httpStatus;
    private final String message;
}
