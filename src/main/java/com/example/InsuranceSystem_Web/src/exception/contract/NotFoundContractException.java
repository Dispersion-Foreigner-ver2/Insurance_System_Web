package com.example.InsuranceSystem_Web.src.exception.contract;

public class NotFoundContractException extends ContractException {
    public NotFoundContractException() {
        super(ContractExceptionStatus.NOT_FOUND_CONTRACT.getCode(),
                ContractExceptionStatus.NOT_FOUND_CONTRACT.getHttpStatus(),
                ContractExceptionStatus.NOT_FOUND_CONTRACT.getMessage());
    }
}
