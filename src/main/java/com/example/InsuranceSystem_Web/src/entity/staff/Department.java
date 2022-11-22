package com.example.InsuranceSystem_Web.src.entity.staff;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Department {
    Design("보험 설계부"),
    Underwriting("인수 심사부"),
    Sales("영업 관리부"),
    Human("인사 관리부"),
    CompensationManagement("보상 운영부");

    String label;
}
