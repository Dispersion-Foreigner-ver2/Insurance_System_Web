package com.example.InsuranceSystem_Web.src.controller;


import com.example.InsuranceSystem_Web.config.BaseResponse;
import com.example.InsuranceSystem_Web.src.dto.customer.PostCustomerJoinDto;
import com.example.InsuranceSystem_Web.src.service.customer.CustomerService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.Binding;
import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@Api(tags ="4. customer API ")
@Slf4j
public class CustomerController {

    private final CustomerService customerService;

    /**
     * 보험가입자를 관리한다.
     * - 이달의 보험료를 미납한 보험가입자의 수
     * */


    /**
     * 보험가입자를 관리한다.
     * - 보험가입자 상세보기
     * */


    /**
     * 보험료를 납입받는다.
     * */


}
