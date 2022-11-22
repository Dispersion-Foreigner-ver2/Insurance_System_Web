package com.example.InsuranceSystem_Web.src.dto.staff;

import com.example.InsuranceSystem_Web.src.entity.staff.Department;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class StaffMainForm {

    private long id;
    private Department department;
    private String name;

}
