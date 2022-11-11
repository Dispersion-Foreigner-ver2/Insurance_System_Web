package com.example.InsuranceSystem_Web.src.insurance.exception;

import com.example.InsuranceSystem_Web.config.BaseException;
import org.springframework.http.HttpStatus;

public abstract class InsuranceException extends BaseException {

    protected InsuranceException(int code, HttpStatus httpStatus, String message) {
        super(code, httpStatus, message);
    }

}
