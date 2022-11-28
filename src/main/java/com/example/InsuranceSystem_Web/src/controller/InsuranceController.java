package com.example.InsuranceSystem_Web.src.controller;

import com.example.InsuranceSystem_Web.config.BaseResponse;
import com.example.InsuranceSystem_Web.src.service.insurance.InsuranceService;
import com.example.InsuranceSystem_Web.src.vo.insurance.PostInsuranceRes;
import com.example.InsuranceSystem_Web.src.dto.insurance.PostCarInsuranceDto;
import com.example.InsuranceSystem_Web.src.dto.insurance.PostFireInsuranceDto;
import com.example.InsuranceSystem_Web.src.dto.insurance.PostSeaInsuranceDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@RequiredArgsConstructor
@Controller
@RequestMapping("/insurance")
@Api(tags ="1. insurance API ")
@Slf4j
public class InsuranceController {

    private final InsuranceService insuranceService;

    /**
     * 보험을 설계한다.
     * */

    // 자동차
    @ApiOperation(value = "자동차 보험을 설계한다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK", response = PostInsuranceRes.class)
    })
    @PostMapping("/design/car")
    public ResponseEntity<?> createInsuranceCar(@Valid PostCarInsuranceDto postCarInsuranceDto){
        insuranceService.createInsuranceCar(postCarInsuranceDto);
        return ResponseEntity.ok(new BaseResponse(insuranceService.createInsuranceCar(postCarInsuranceDto)));
    }

    // 화재
    @ApiOperation(value = "화재 보험을 설계한다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK", response = PostInsuranceRes.class)
    })
    @PostMapping("/design/fire")
    public ResponseEntity<?> createInsuranceFire(@Valid PostFireInsuranceDto postFireRequest){
        insuranceService.createInsuranceFire(postFireRequest);
        return ResponseEntity.ok(new BaseResponse(insuranceService.createInsuranceFire(postFireRequest)));
    }

    // 바다
    @ApiOperation(value = "보험을 설계한다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK", response = PostInsuranceRes.class)
    })
    @PostMapping("/design/sea")
    public ResponseEntity<?> createInsuranceSea(@Valid PostSeaInsuranceDto postSeaRequest){
        return ResponseEntity.ok(new BaseResponse(insuranceService.createInsuranceSea(postSeaRequest)));
    }



    /**
     * 보험을 관리한다
     * */



    /**
     * 보험을 인가 받는다
     * */

}
