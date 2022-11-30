package com.example.InsuranceSystem_Web.src.exception.insuranceException;

import org.springframework.http.HttpStatus;

import static com.example.InsuranceSystem_Web.src.exception.insuranceException.InsuranceExceptionType.EMPTY_INSURANCE;

public class InsuranceEmptyException extends InsuranceException{

    public InsuranceEmptyException() {
        super(EMPTY_INSURANCE.getCode(),
                EMPTY_INSURANCE.getHttpStatus(),
                EMPTY_INSURANCE.getMessage());
    }

}
