package com.example.InsuranceSystem_Web.src.exception.customerException;

import com.example.InsuranceSystem_Web.src.exception.global.BaseException;
import com.example.InsuranceSystem_Web.src.exception.global.BaseExceptionType;

public class CustomerException extends BaseException {
    private BaseExceptionType exceptionType;

    public CustomerException(BaseExceptionType exceptionType) {
        this.exceptionType = exceptionType;
    }

    @Override
    public BaseExceptionType getExceptionType() {
        return exceptionType;
    }
}