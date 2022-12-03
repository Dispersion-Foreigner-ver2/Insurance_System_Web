package com.example.InsuranceSystem_Web.src.vo.staff;


import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PostStaffVo {
    private String message;

    private Long staffId;
    private String staffName;
    private String department;
}
