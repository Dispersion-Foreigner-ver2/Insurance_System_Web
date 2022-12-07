package com.example.InsuranceSystem_Web.src.exception.contract;

public class WrongJoinCustomerException extends ContractException {
    public WrongJoinCustomerException() {
        super(ContractExceptionStatus.WRONG_JOIN_CUSTOMER.getCode(),
                ContractExceptionStatus.WRONG_JOIN_CUSTOMER.getHttpStatus(),
                ContractExceptionStatus.WRONG_JOIN_CUSTOMER.getMessage());
    }
}
