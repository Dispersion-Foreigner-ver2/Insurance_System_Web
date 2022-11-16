package com.example.InsuranceSystem_Web.exception.staffException;

import com.example.InsuranceSystem_Web.exception.global.BaseExceptionType;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
public enum StaffExceptionType implements BaseExceptionType {
    NOT_FOUND_STAFF(600, HttpStatus.OK, "등록된 정보가 없습니다. 다시 시도해주시거나 회원 가입 후 진행해주세요."),
    WRONG_JOIN_STAFF(601, HttpStatus.OK, "가입에 실패하였습니다. 다시 시도해주세요."),
    WRONG_TYPE_INPUT(602, HttpStatus.OK, "아이디는 숫자만 입력해 주세요.");

    private int errorCode;
    private HttpStatus httpStatus;
    private String errorMessage;




    @Override
    public int getErrorCode() {
        return errorCode;
    }

    @Override
    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    @Override
    public String getErrorMessage() {
        return errorMessage;
    }
}
