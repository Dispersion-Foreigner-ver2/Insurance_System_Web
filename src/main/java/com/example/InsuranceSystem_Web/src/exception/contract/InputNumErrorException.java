package com.example.InsuranceSystem_Web.src.exception.contract;

public class InputNumErrorException extends ContractException {
    public InputNumErrorException() {
        super(ContractExceptionStatus.INPUT_NUM_ERROR.getCode(),
                ContractExceptionStatus.INPUT_NUM_ERROR.getHttpStatus(),
                ContractExceptionStatus.INPUT_NUM_ERROR.getMessage());
    }
}
