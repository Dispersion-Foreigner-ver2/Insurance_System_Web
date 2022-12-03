package com.example.InsuranceSystem_Web.src.controller;

import com.example.InsuranceSystem_Web.config.BaseResponse;
import com.example.InsuranceSystem_Web.src.dto.staff.PostStaffJoinDto;
import com.example.InsuranceSystem_Web.src.dto.staff.PostStaffLoginDto;
import com.example.InsuranceSystem_Web.src.entity.staff.Staff;
import com.example.InsuranceSystem_Web.src.exception.staffException.StaffException;
import com.example.InsuranceSystem_Web.src.service.staff.StaffService;
import com.example.InsuranceSystem_Web.src.service.staff.StaffServiceImpl;
import com.example.InsuranceSystem_Web.src.vo.insurance.PostInsuranceVo;
import com.example.InsuranceSystem_Web.src.vo.staff.PostStaffVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@Api(tags ="3. staff API ")
@Slf4j
public class StaffController {

    private final StaffService staffService;


    //로그인
    @ApiOperation(value = "로그인 한다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK", response = PostStaffVo.class)
    })
    @PostMapping("/login")
    private ResponseEntity<?> login(@Valid PostStaffLoginDto postStaffLoginDto){
        return ResponseEntity.ok(new BaseResponse(staffService.login(postStaffLoginDto)));
    }



    //회원 가입
    @ApiOperation(value = "회원가입 한다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK", response = PostStaffVo.class)
    })
    @PostMapping("/staffJoin")
    private ResponseEntity<?> join(@Valid PostStaffJoinDto postStaffJoinDto)  {
        return ResponseEntity.ok(new BaseResponse(staffService.join(postStaffJoinDto)));
    }

}
