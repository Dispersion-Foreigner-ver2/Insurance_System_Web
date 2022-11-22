package com.example.InsuranceSystem_Web.src.exception.staffException;

import com.example.InsuranceSystem_Web.src.exception.global.BaseException;
import com.example.InsuranceSystem_Web.src.exception.global.BaseExceptionType;

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
