package com.example.InsuranceSystem_Web.src.entity.customer.enums;

public enum Disease {
    암(false),
    결핵(true),
    수두(true),
    홍역(true),
    없음(true);

    private boolean pass;

    private Disease(boolean pass) {
        this.pass = pass;
    }

    public boolean isPass() {
        return this.pass;
    }
}