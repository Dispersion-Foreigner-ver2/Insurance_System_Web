package com.example.InsuranceSystem_Web.src.service.staff;

import com.example.InsuranceSystem_Web.src.dto.req.staff.PostStaffJoinReq;
import com.example.InsuranceSystem_Web.src.dto.req.staff.PostStaffLoginReq;
import com.example.InsuranceSystem_Web.src.dto.res.staff.GetStaffRes;
import com.example.InsuranceSystem_Web.src.dto.res.staff.PostStaffRes;

import java.util.List;

public interface StaffService {

    PostStaffRes login(PostStaffLoginReq postStaffLoginDto);

    PostStaffRes join(PostStaffJoinReq postStaffJoinDto);

    List<GetStaffRes> getStaffList();
    Object getStaff(long id);

    Object deleteStaff(long id);
    Object getSalary(long id);

    Object changePosition(long id, int position);

    Object changeDepartment(long id, int department);
}
