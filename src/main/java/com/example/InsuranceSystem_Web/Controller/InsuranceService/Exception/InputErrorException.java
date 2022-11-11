package com.example.InsuranceSystem_Web.Controller.InsuranceService.Exception;

import com.example.InsuranceSystem_Web.config.BaseResponseStatus;

public class InputErrorException extends InsuranceException{
    public InputErrorException() {
        super(BaseResponseStatus.REQUEST_ERROR.getCode(),
                BaseResponseStatus.REQUEST_ERROR.getHttpStatus(),
                BaseResponseStatus.REQUEST_ERROR.getMessage());
    }
}
