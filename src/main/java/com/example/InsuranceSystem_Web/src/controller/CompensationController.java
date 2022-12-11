package com.example.InsuranceSystem_Web.src.controller;

import com.example.InsuranceSystem_Web.config.BaseResponse;
import com.example.InsuranceSystem_Web.src.dto.compensation.PostCarDisclaimerDto;
import com.example.InsuranceSystem_Web.src.dto.compensation.PostCompensationAmountDto;
import com.example.InsuranceSystem_Web.src.dto.insurance.PostFireInsuranceDto;
import com.example.InsuranceSystem_Web.src.entity.insurance.FireInsurance;
import com.example.InsuranceSystem_Web.src.service.compensation.CompensationService;
import com.example.InsuranceSystem_Web.src.service.customer.CustomerService;
import com.example.InsuranceSystem_Web.src.vo.compensation.GetCompensationVo;
import com.example.InsuranceSystem_Web.src.vo.compensation.PostCarDisclaimerVo;
import com.example.InsuranceSystem_Web.src.vo.compensation.PostCompensationAmountVo;
import com.example.InsuranceSystem_Web.src.vo.customer.GetCustomerCountVo;
import com.example.InsuranceSystem_Web.src.vo.insurance.PostInsuranceVo;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/compensation")
@Api(tags ="4. compensation API ")
@Slf4j
public class CompensationController {
    private final CompensationService compensationService;

    /**
     * 고객 보상을 관리한다.
     * */
    @ApiOperation(value = "고객 보상을 관리한다 ")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK", response = GetCompensationVo.class),
    })
    @GetMapping("/manage")
    public ResponseEntity<?> compensation(@RequestParam("customerId") @ApiParam(value = "계약 아이디",example = "0", defaultValue = "3") Long customerId){
        return ResponseEntity.ok(new BaseResponse(compensationService.compensation(customerId)));
    }

    /**
     * 면부책을 판단한다.
     * */
    @ApiOperation(value = "자동차 보험 면부책을 판단한다..")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK", response = PostCarDisclaimerVo.class)
    })
    @PostMapping("/car")
    public ResponseEntity<?> carDisclaimer(PostCarDisclaimerDto postCarDisclaimerDto){
        return ResponseEntity.ok(new BaseResponse(compensationService.carDisclaimer(postCarDisclaimerDto)));
//    }
//    @ApiOperation(value = "화재 보험 면부책을 판단한다..")
//    @ApiResponses({
//            @ApiResponse(code = 200, message = "OK", response = PostCompensationAmountVo.class)
//    })
//    @PostMapping("/car")
//    public ResponseEntity<?> firedisclaimer(  ){
//        return ResponseEntity.ok(new BaseResponse(compensationService.firedisclaimer()));
//    }
//    @ApiOperation(value = "해상 보험 면부책을 판단한다..")
//    @ApiResponses({
//            @ApiResponse(code = 200, message = "OK", response = PostCompensationAmountVo.class)
//    })
//    @PostMapping("/car")
//    public ResponseEntity<?> seadisclaimer(  ){
//        return ResponseEntity.ok(new BaseResponse(compensationService.seadisclaimer()));
//    }


    /**
     * 보상액을 지급한다.
     * */
//    @ApiOperation(value = "보상액을 지급한다.")
//    @ApiResponses({
//            @ApiResponse(code = 200, message = "OK", response = PostCompensationAmountVo.class)
//    })
//    @PostMapping("/pay")
//    public ResponseEntity<?> compensationAmount(PostFireInsuranceDto postFireInsuranceDto ){
//        return ResponseEntity.ok(new BaseResponse(compensationService.compensationAmount(postFireInsuranceDto)));
    }
}
