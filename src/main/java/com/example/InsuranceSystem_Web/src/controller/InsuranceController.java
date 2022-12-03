package com.example.InsuranceSystem_Web.src.controller;

import com.example.InsuranceSystem_Web.config.BaseResponse;
import com.example.InsuranceSystem_Web.src.service.insurance.InsuranceService;
import com.example.InsuranceSystem_Web.src.vo.insurance.PostInsuranceVo;
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
import org.springframework.web.bind.annotation.*;

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
            @ApiResponse(code = 200, message = "OK", response = PostInsuranceVo.class)
    })
    @PostMapping("/design/car")
    public ResponseEntity<?> createInsuranceCar(@RequestBody @Valid PostCarInsuranceDto postCarInsuranceDto){
        return ResponseEntity.ok(new BaseResponse(insuranceService.createInsuranceCar(postCarInsuranceDto)));
    }

    // 화재
    @ApiOperation(value = "화재 보험을 설계한다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK", response = PostInsuranceVo.class)
    })
    @PostMapping("/design/fire")
    public ResponseEntity<?> createInsuranceFire(@RequestBody @Valid PostFireInsuranceDto postFireRequest){
        return ResponseEntity.ok(new BaseResponse(insuranceService.createInsuranceFire(postFireRequest)));
    }

    // 바다
    @ApiOperation(value = "해상 보험을 설계한다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK", response = PostInsuranceVo.class)
    })
    @PostMapping("/design/sea")
    public ResponseEntity<?> createInsuranceSea(@RequestBody @Valid PostSeaInsuranceDto postSeaRequest){
        return ResponseEntity.ok(new BaseResponse(insuranceService.createInsuranceSea(postSeaRequest)));
    }


    /**
     * 보험을 관리한다
     * -> 전체 보험을 나타 낸다. - 자사의 총 보험 개수, 자사의 인가받은 보험의 개수, 자사의 인가 받지 못한 보험의 개수
     * */
    @GetMapping("/count")
    public ResponseEntity<?> readInsuranceCount(){
        return ResponseEntity.ok(new BaseResponse(insuranceService.readInsuranceCount()));
    }


    /**
     * 보험을 인가 받는다
     * */
    @PostMapping("/auth")
    public ResponseEntity<?> updateAuthorize(@RequestParam("id") Long insuranceId){
        return ResponseEntity.ok(new BaseResponse(insuranceService.setAuthorize(insuranceId)));
    }


    /**
     * 보험을 삭제한다.
     * */
    @DeleteMapping("delete")
    public ResponseEntity<?> deleteInsurance(@RequestParam("id") Long insuranceId){
        return ResponseEntity.ok(new BaseResponse(insuranceService.deleteInsurance(insuranceId)));
    }


    /**
     * 보험을 관리한다
     * - 전체 보험리스트를 나타 낸다.
     * http://localhost:8080/insurance/all
     * */
    @GetMapping("/all")
    public ResponseEntity<?> readInsurance(){
        return ResponseEntity.ok(new BaseResponse(insuranceService.readInsurance()));
    }

    /**
     * 보험을 관리한다
     * - 상세화면을 볼 수 있다.
     * http://localhost:8080/insurance?id=7
     * */
    @GetMapping("")
    public ResponseEntity<?> readDetailInsurance(@RequestParam("id") Long insuranceId){
        return ResponseEntity.ok(new BaseResponse(insuranceService.readDetailInsurance(insuranceId)));
    }


}
