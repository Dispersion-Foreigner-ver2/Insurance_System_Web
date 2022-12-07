package com.example.InsuranceSystem_Web.src.exception.contract;

import com.example.InsuranceSystem_Web.config.BaseException;
import org.springframework.http.HttpStatus;


public abstract class ContractException extends BaseException {
    public ContractException(int code, HttpStatus httpStatus, String message) {
        super(code, httpStatus, message);
    }
}
