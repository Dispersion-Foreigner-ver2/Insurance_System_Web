package com.example.InsuranceSystem_Web.src.exception.staff;

public class NotFoundStaffException extends StaffException{
    public NotFoundStaffException() {
        super(StaffExceptionStatus.NOT_FOUND_STAFF.getCode(),
                StaffExceptionStatus.NOT_FOUND_STAFF.getHttpStatus(),
                StaffExceptionStatus.NOT_FOUND_STAFF.getMessage());
    }
}
