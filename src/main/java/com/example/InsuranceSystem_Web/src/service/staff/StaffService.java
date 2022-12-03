package com.example.InsuranceSystem_Web.src.service.staff;

import com.example.InsuranceSystem_Web.src.dto.staff.PostStaffJoinDto;
import com.example.InsuranceSystem_Web.src.dto.staff.PostStaffLoginDto;
import com.example.InsuranceSystem_Web.src.vo.staff.*;

import java.util.List;

public interface StaffService {

    PostStaffVo login(PostStaffLoginDto postStaffLoginDto);

    PostStaffVo join(PostStaffJoinDto postStaffJoinDto);

    List<GetStaffVo> getStaffList();
    Object getStaff(long id);

    Object deleteStaff(long id);
    Object getSalary(long id);

    Object changePosition(long id, int position);

    Object changeDepartment(long id, int department);
}
