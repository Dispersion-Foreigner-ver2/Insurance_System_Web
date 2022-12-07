package com.example.InsuranceSystem_Web.src.exception.insurance;

public class EmptyInsuranceException extends InsuranceException{
    public EmptyInsuranceException() {
        super(InsuranceExceptionStatus.EMPTY_INSURANCE.getCode(),
                InsuranceExceptionStatus.EMPTY_INSURANCE.getHttpStatus(),
                InsuranceExceptionStatus.EMPTY_INSURANCE.getMessage());
    }
}
