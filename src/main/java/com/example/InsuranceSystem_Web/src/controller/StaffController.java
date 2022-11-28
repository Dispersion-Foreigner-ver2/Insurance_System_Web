package com.example.InsuranceSystem_Web.src.controller;

import com.example.InsuranceSystem_Web.src.dto.staff.PostStaffJoinDto;
import com.example.InsuranceSystem_Web.src.dto.staff.PostStaffLoginDto;
import com.example.InsuranceSystem_Web.src.entity.staff.Staff;
import com.example.InsuranceSystem_Web.src.exception.staffException.StaffException;
import com.example.InsuranceSystem_Web.src.service.staff.StaffService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
@Slf4j
public class StaffController {

    private final StaffService staffService;

    @Autowired
    public StaffController(StaffService staffService) {
        this.staffService = staffService;
    }

    //로그인

    @GetMapping("/")
    private String login(Model model) {
        model.addAttribute("staffLoginForm", new PostStaffLoginDto());
        return "staffLogin";
    }

    @PostMapping("login")
    private String login(@Valid PostStaffLoginDto postStaffLoginDto, BindingResult result, Model model) throws Exception {

        if (result.hasErrors()) {
            return "staffLogin";
        }

        Staff staff = staffService.login(postStaffLoginDto);

        switch (staff.getDepartment()) {
            case Design:
                return "designMain";
            case Underwriting:
                return "underWritingMain";
            case Sales:
                return "salesMain";
            case Human:
                return "humanMain";
            case CompensationManagement:
                return "compensationManagementMain";
        }
        return "staffLogin";
    }



    //회원 가입
    @GetMapping("/staffJoin")
    private String join(Model model) {

        model.addAttribute("staffJoinForm", new PostStaffJoinDto());
        return "staffJoin";
    }

    @PostMapping("/staffJoin")
    private String join(@Valid PostStaffJoinDto postStaffJoinDto, BindingResult result) throws Exception {

        if (result.hasErrors()) {
            return "staffJoin";
        }

        staffService.createStaff(postStaffJoinDto);
        Long staffId = Long.parseLong(postStaffJoinDto.getId());
        Staff staff = staffService.getStaff(staffId);
        switch (staff.getDepartment()) {
            case Design:
                return "designMain";
            case Underwriting:
                return "underWritingMain";
            case Sales:
                return "salesMain";
            case Human:
                return "humanMain";
            case CompensationManagement:
                return "compensationManagementMain";
        }
        return "staffJoin";

    }



    @GetMapping("/{staffId}")
    private String main(@PathVariable("staffId") String staffId, Model model) {
        Long findStaffId = Long.parseLong(staffId);
        Staff staff = staffService.getStaff(findStaffId);


        return "redirect:/";
    }


    @ExceptionHandler(StaffException.class)
    private String staffException(Model model, StaffException e) {
        log.info(e.getExceptionType().getErrorMessage());
        model.addAttribute("exception", e.getExceptionType().getErrorMessage());
        return "error";
    }
}
