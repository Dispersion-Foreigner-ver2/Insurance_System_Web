package com.example.InsuranceSystem_Web.src.Controller.InsuranceService.Exception;

import com.example.InsuranceSystem_Web.config.BaseException;
import org.springframework.http.HttpStatus;

public abstract class InsuranceException extends BaseException {

    protected InsuranceException(int code, HttpStatus httpStatus, String message) {
        super(code, httpStatus, message);
    }

}
