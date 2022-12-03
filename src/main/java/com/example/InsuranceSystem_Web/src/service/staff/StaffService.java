package com.example.InsuranceSystem_Web.src.service.staff;

import com.example.InsuranceSystem_Web.src.dto.staff.PostStaffJoinDto;
import com.example.InsuranceSystem_Web.src.dto.staff.PostStaffLoginDto;
import com.example.InsuranceSystem_Web.src.vo.staff.PostStaffVo;

public interface StaffService {

    PostStaffVo login(PostStaffLoginDto postStaffLoginDto);

    PostStaffVo join(PostStaffJoinDto postStaffJoinDto);

}
