package com.example.InsuranceSystem_Web.exception.staffException;

import com.example.InsuranceSystem_Web.exception.global.BaseException;
import com.example.InsuranceSystem_Web.exception.global.BaseExceptionType;

public class StaffException extends BaseException {
    private BaseExceptionType exceptionType;

    public StaffException(BaseExceptionType exceptionType) {
        this.exceptionType = exceptionType;
    }

    @Override
    public BaseExceptionType getExceptionType() {
        return exceptionType;
    }
}
