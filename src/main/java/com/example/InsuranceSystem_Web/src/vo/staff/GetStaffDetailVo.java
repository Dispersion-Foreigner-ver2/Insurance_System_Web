package com.example.InsuranceSystem_Web.src.vo.staff;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
@AllArgsConstructor
public class GetStaffDetailVo {
    private long id; // 사원 번호
    private String Department; // 부서 이름
    private String name;
    private String SSN; // 주민번호
    private String email;
    private String phoneNum;
    private LocalDate joinDate;
}
