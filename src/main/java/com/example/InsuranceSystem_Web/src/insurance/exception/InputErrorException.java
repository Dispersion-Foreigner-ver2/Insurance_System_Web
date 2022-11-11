package com.example.InsuranceSystem_Web.src.insurance.exception;

import com.example.InsuranceSystem_Web.config.BaseResponseStatus;

public class InputErrorException extends InsuranceException{
    public InputErrorException() {
        super(BaseResponseStatus.REQUEST_ERROR.getCode(),
                BaseResponseStatus.REQUEST_ERROR.getHttpStatus(),
                BaseResponseStatus.REQUEST_ERROR.getMessage());
    }
}
