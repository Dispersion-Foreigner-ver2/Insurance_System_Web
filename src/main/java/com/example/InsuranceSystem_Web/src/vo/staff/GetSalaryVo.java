package com.example.InsuranceSystem_Web.src.vo.staff;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
@AllArgsConstructor
public class GetSalaryVo {
    private String position; // 직급
    private int workDay; // 근무 일 수
    private int result; // 보너스 실적
    private int totalSalary; // 최종 월급
}
