package com.example.InsuranceSystem_Web.src.exception.staff;

import com.example.InsuranceSystem_Web.config.BaseException;
import org.springframework.http.HttpStatus;

public abstract class StaffException extends BaseException {
    public StaffException(int code, HttpStatus httpStatus, String message) {
        super(code, httpStatus, message);
    }
}
