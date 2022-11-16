package com.example.InsuranceSystem_Web.domain.Staff;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Position {
    Staff(1500000, "평사원"), //사원
    Supervisor(2000000, "주임"),
    AssistantManager(2500000, "대리"),
    Manager(3000000, "과장"),
    DeputyGeneralManager(3500000, "차장"),
    GeneralManager(4000000, "부장");

    private int salary;
    private String label;
}
