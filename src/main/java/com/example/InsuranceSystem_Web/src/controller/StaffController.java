package com.example.InsuranceSystem_Web.src.controller;

import com.example.InsuranceSystem_Web.config.BaseResponse;
import com.example.InsuranceSystem_Web.src.dto.staff.PostStaffJoinDto;
import com.example.InsuranceSystem_Web.src.dto.staff.PostStaffLoginDto;
import com.example.InsuranceSystem_Web.src.service.staff.StaffService;
import com.example.InsuranceSystem_Web.src.vo.staff.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
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

    /**
     * 사원을 관리한다.
     * - 전체보기
     * */
    @GetMapping("/staff")
    private ResponseEntity<?> getStaffList()  {
        return ResponseEntity.ok(new BaseResponse(staffService.getStaffList()));
    }

    /**
     * 사원을 관리한다.
     * - 상세보기
     * */
    @GetMapping("/staff/detail")
    private ResponseEntity<?> getStaff(@RequestParam("id")long id)  {
        return ResponseEntity.ok(new BaseResponse(staffService.getStaff(id)));
    }

    /**
     * 사원을 관리한다.
     * - 해고하기
     * */
    @DeleteMapping("/staff")
    private ResponseEntity<?> deleteStaff(@RequestParam("id")long id)  {
        return ResponseEntity.ok(new BaseResponse(staffService.deleteStaff(id)));
    }

    /**
     * 사원을 관리한다.
     * - 부서이동
     * */
    @PostMapping("/staff/department")
    private ResponseEntity<?> changeDepartment(@RequestParam("id")long id,
                                             @RequestParam("changeDepartment") int department)  {
        return ResponseEntity.ok(new BaseResponse(staffService.changeDepartment(id, department)));
    }

    /**
     * 사원 월급을 관리한다.
     * - 사원의 월급을 보여준다.
     * */
    @GetMapping("/staff/salary")
    private ResponseEntity<?> getSalary(@RequestParam("id")long id)  {
        return ResponseEntity.ok(new BaseResponse(staffService.getSalary(id)));
    }

    /**
     * 사원 월급을 관리한다.
     * - 직급 변경 (직급에 따라 월급 변경)
     * */
    @PostMapping("/staff/position")
    private ResponseEntity<?> changePosition(@RequestParam("id")long id,
                                             @RequestParam("changePosition") int position)  {
        return ResponseEntity.ok(new BaseResponse(staffService.changePosition(id, position)));
    }


}
