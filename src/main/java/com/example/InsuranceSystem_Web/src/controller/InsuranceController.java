package com.example.InsuranceSystem_Web.src.controller;

import com.example.InsuranceSystem_Web.config.BaseResponse;
import com.example.InsuranceSystem_Web.src.service.insurance.InsuranceService;
import com.example.InsuranceSystem_Web.src.vo.insurance.PostInsuranceRes;
import com.example.InsuranceSystem_Web.src.dto.insurance.PostCarReq;
import com.example.InsuranceSystem_Web.src.dto.insurance.PostFireReq;
import com.example.InsuranceSystem_Web.src.dto.insurance.PostSeaReq;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/insurance")
@Api(tags ="1. insurance API ")
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
    public ResponseEntity<?> createInsuranceCar(@Valid @RequestBody PostCarReq postCarReq){
        return ResponseEntity.ok(new BaseResponse(insuranceService.createInsuranceCar(postCarReq)));
    }

    // 화재
    @ApiOperation(value = "화재 보험을 설계한다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK", response = PostInsuranceRes.class)
    })
    @PostMapping("/design/fire")
    public ResponseEntity<?> createInsuranceFire(@Valid @RequestBody PostFireReq postFireRequest){
        return ResponseEntity.ok(new BaseResponse(insuranceService.createInsuranceFire(postFireRequest)));
    }

    // 바다
    @ApiOperation(value = "보험을 설계한다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK", response = PostInsuranceRes.class)
    })
    @PostMapping("/design/sea")
    public ResponseEntity<?> createInsuranceSea(@Valid @RequestBody PostSeaReq postSeaRequest){
        return ResponseEntity.ok(new BaseResponse(insuranceService.createInsuranceSea(postSeaRequest)));
    }



    /**
     * 보험을 관리한다
     * */



    /**
     * 보험을 인가 받는다
     * */

}
