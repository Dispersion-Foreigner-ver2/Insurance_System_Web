package com.example.InsuranceSystem_Web.src.controller;


import com.example.InsuranceSystem_Web.config.BaseResponse;
import com.example.InsuranceSystem_Web.src.service.customer.CustomerService;
import com.example.InsuranceSystem_Web.src.vo.customer.GetCustomerCountVo;
import com.example.InsuranceSystem_Web.src.vo.customer.GetCustomerVo;
import com.example.InsuranceSystem_Web.src.vo.insurance.GetInsuranceVo;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/customer")
@Api(tags ="4. customer API ")
@Slf4j
public class CustomerController {

    private final CustomerService customerService;

    /**
     * 보험가입자를 관리한다.
     * - 이달의 보험료를 미납한 보험가입자의 수
     * */
    @ApiOperation(value = "보험 가입자를 관리한다 ")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK", response = GetCustomerCountVo.class),
    })
    @GetMapping("/manage")
    public ResponseEntity<?> readCustomerCount(){
        return ResponseEntity.ok(new BaseResponse(customerService.readCustomerCount()));
    }


    /**
     * 보험가입자를 관리한다.
     * - 보험가입자 상세보기
     * */
    @ApiOperation(value = "보험을 관리한다 - 상세화면을 볼 수 있다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK", response = GetCustomerVo.class)
    })
    @GetMapping("/detail")
    //@RequestParam("id") @ApiParam(value = "고객 아이디",example = "0") Long customerId
    public ResponseEntity<?> readDetailCustomer(){
        return ResponseEntity.ok(new BaseResponse(customerService.readDetailCustomer()));
    }

    /**
     * 보험료를 납입받는다.
     * */
//    @ApiOperation(value = "보험을 관리한다 - 상세화면을 볼 수 있다.")
//    @ApiResponses({
//            @ApiResponse(code = 200, message = "OK", response = GetCustomerVo.class)
//    })
//    @GetMapping("/getPay")
//    //@RequestParam("id") @ApiParam(value = "고객 아이디",example = "0") Long customerId
//    public ResponseEntity<?> readDetailCustomer(){
//        return ResponseEntity.ok(new BaseResponse(customerService.readDetailCustomer()));
//    }

}
