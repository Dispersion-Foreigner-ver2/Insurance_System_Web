package com.example.InsuranceSystem_Web.src.exception.contract;

public class EmptyCustomerContractException extends ContractException {
    public EmptyCustomerContractException() {
        super(ContractExceptionStatus.EMPTY_CUSTOMER_CONTRACT.getCode(),
                ContractExceptionStatus.EMPTY_CUSTOMER_CONTRACT.getHttpStatus(),
                ContractExceptionStatus.EMPTY_CUSTOMER_CONTRACT.getMessage());
    }
}
