package com.example.InsuranceSystem_Web.src.insurance.controller;

import com.example.InsuranceSystem_Web.src.insurance.dto.PostInsuranceRequest;
import com.example.InsuranceSystem_Web.src.insurance.dto.PostInsuranceResponse;
import com.example.InsuranceSystem_Web.config.BaseResponse;
import com.example.InsuranceSystem_Web.src.insurance.service.InsuranceService;
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
    @ApiOperation(value = "보험을 설계한다.")
    @ApiResponses({  // Response Message 에 대한 Swagger 설명
            @ApiResponse(code = 200, message = "OK", response = PostInsuranceResponse.class)
    })
    @PostMapping("/design")
    public ResponseEntity<?> createInsurance(@Valid @RequestBody PostInsuranceRequest postInsuranceRequest){
        insuranceService.design(postInsuranceRequest);
        return ResponseEntity
                .ok(new BaseResponse(PostInsuranceResponse.builder().message("성공").build()));
    }


    /**
     * 보험을 관리한다
     * */



    /**
     * 보험을 인가 받는다
     * */

}
