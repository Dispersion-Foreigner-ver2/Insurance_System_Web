package com.example.InsuranceSystem_Web.exception.global;

public abstract class BaseException extends RuntimeException {
    public abstract BaseExceptionType getExceptionType();
}
