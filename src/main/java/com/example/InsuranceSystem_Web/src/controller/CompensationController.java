package com.example.InsuranceSystem_Web.src.controller;

import com.example.InsuranceSystem_Web.config.BaseResponse;
import com.example.InsuranceSystem_Web.src.dto.req.compensation.PostCarDisclaimerReq;
import com.example.InsuranceSystem_Web.src.service.compensation.CompensationService;
import com.example.InsuranceSystem_Web.src.dto.res.compensation.GetCompensationRes;
import com.example.InsuranceSystem_Web.src.dto.res.compensation.PostCarDisclaimerRes;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
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
            @ApiResponse(code = 200, message = "OK", response = GetCompensationRes.class),
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
            @ApiResponse(code = 200, message = "OK", response = PostCarDisclaimerRes.class)
    })
    @PostMapping("/car")
    public ResponseEntity<?> carDisclaimer(PostCarDisclaimerReq postCarDisclaimerDto){
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
