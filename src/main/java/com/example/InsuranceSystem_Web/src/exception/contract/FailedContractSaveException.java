package com.example.InsuranceSystem_Web.src.exception.contract;

public class FailedContractSaveException extends ContractException {
    public FailedContractSaveException() {
        super(ContractExceptionStatus.FAILED_CONTRACT_SAVE.getCode(),
                ContractExceptionStatus.FAILED_CONTRACT_SAVE.getHttpStatus(),
                ContractExceptionStatus.FAILED_CONTRACT_SAVE.getMessage());
    }
}
