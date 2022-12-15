package com.example.InsuranceSystem_Web.src.dto.res.staff;


import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PostStaffRes {
    private String message;

    private Long staffId;
    private String staffName;
    private String department;
}
