package com.example.InsuranceSystem_Web.src.entity.customer.enums;

public enum Job {
    영업직(70, false),
    생산직(60, true),
    사무직(75, false),
    자영업자(70, true),
    무직(30, false);

    private int maxAge;
    private boolean danger;

    private Job(int maxAge, boolean danger) {
        this.maxAge = maxAge;
        this.danger = danger;
    }

    public int getMaxAge() {
        return this.maxAge;
    }

    public boolean isDanger() {
        return this.danger;
    }
}
