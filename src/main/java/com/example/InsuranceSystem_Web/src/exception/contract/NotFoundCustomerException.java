package com.example.InsuranceSystem_Web.src.exception.contract;

import com.example.InsuranceSystem_Web.src.exception.insurance.InsuranceException;
import com.example.InsuranceSystem_Web.src.exception.insurance.InsuranceExceptionStatus;

public class NotFoundCustomerException extends ContractException {
    public NotFoundCustomerException() {
        super(ContractExceptionStatus.NOT_FOUND_CUSTOMER.getCode(),
                ContractExceptionStatus.NOT_FOUND_CUSTOMER.getHttpStatus(),
                ContractExceptionStatus.NOT_FOUND_CUSTOMER.getMessage());
    }
}
