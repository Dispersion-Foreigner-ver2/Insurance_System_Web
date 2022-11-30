package com.example.InsuranceSystem_Web.src.exception.insuranceException;

import com.example.InsuranceSystem_Web.config.BaseException;

import com.example.InsuranceSystem_Web.src.exception.global.BaseExceptionType;
import org.springframework.http.HttpStatus;

public abstract class InsuranceException extends BaseException {

    public InsuranceException(int code, HttpStatus httpStatus, String message) {
        super(code, httpStatus, message);
    }
}