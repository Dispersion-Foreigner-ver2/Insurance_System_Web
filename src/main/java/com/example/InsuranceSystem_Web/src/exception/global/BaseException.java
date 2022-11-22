package com.example.InsuranceSystem_Web.src.exception.global;

public abstract class BaseException extends RuntimeException {
    public abstract BaseExceptionType getExceptionType();
}
