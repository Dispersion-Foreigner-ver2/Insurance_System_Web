package com.example.InsuranceSystem_Web.src.exception.staff;

public class WrongTypeInputException extends StaffException{
    public WrongTypeInputException() {
        super(StaffExceptionStatus.WRONG_TYPE_INPUT.getCode(),
                StaffExceptionStatus.WRONG_TYPE_INPUT.getHttpStatus(),
                StaffExceptionStatus.WRONG_TYPE_INPUT.getMessage());
    }
}
