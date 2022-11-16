package com.example.InsuranceSystem_Web.dto;

import com.example.InsuranceSystem_Web.domain.Staff.Department;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class StaffMainForm {

    private long id;
    private Department department;
    private String name;

}
