package com.example.InsuranceSystem_Web.src.exception.staff;

public class WrongJoinStaffException extends StaffException{
    public WrongJoinStaffException() {
        super(StaffExceptionStatus.WRONG_JOIN_STAFF.getCode(),
                StaffExceptionStatus.WRONG_JOIN_STAFF.getHttpStatus(),
                StaffExceptionStatus.WRONG_JOIN_STAFF.getMessage());
    }
}
