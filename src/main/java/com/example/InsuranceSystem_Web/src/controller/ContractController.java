package com.example.InsuranceSystem_Web.src.controller;

import com.example.InsuranceSystem_Web.config.BaseResponse;
import com.example.InsuranceSystem_Web.src.dto.contract.PostContractDto;
import com.example.InsuranceSystem_Web.src.entity.customer.Customer;
import com.example.InsuranceSystem_Web.src.entity.insurance.Insurance;
import com.example.InsuranceSystem_Web.src.service.contract.ContractService;
import com.example.InsuranceSystem_Web.src.vo.contract.PostContractVo;
import com.example.InsuranceSystem_Web.src.vo.insurance.PostInsuranceVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@RequiredArgsConstructor
@Controller
@RequestMapping("/contract")
@Api(tags ="2. contract API ")
@Slf4j
public class ContractController {

    private final ContractService contractService;

    /**
     * 보험 계약을 관리한다.
     * */

//        @ApiOperation(value = "보험 계약을 관리한다.")
//    @ApiResponses({
//            @ApiResponse(code = 200, message = "OK", response = PostInsuranceVo.class)
//    })
    @GetMapping("/contractManage")
    public ResponseEntity<?> contractManage(){
        return ResponseEntity.ok(new BaseResponse(contractService.contractManage()));
    }
//    @GetMapping("/contractManage")
//    public ResponseEntity<?> createContractManage(){
//        return ResponseEntity.ok(new BaseResponse(contractService.createContractManage()));
//    }
    /**
     * 보험 계약을 검색한다.
     * */
//    @ApiOperation(value = "보험 계약을 검색한다.")
//    @ApiResponses({
//            @ApiResponse(code = 200, message = "OK", response = PostInsuranceVo.class)
//    })
//    @GetMapping("/contractSearch")
//    public ResponseEntity<?> contractSearch(Customer customerId){
//        return ResponseEntity.ok(new BaseResponse(contractService.contractSearch(customerId)));
//    }




//    @ApiOperation(value = "보험 계약을 관리한다.")
//    @ApiResponses({
//            @ApiResponse(code = 200, message = "OK", response = PostContractVo.class)
//    })
//
//    @PostMapping("/contract")
//    public ResponseEntity<?> createContract(@RequestBody @Valid PostContractDto postContractDto){
//        // * postman으로 api 실행할때 =>  https://testmanager.tistory.com/342
//        // * delete 폴더는 예전 코드들임
//        // 1. dto 만들어서 보험 계약에 필요한 정보 받아오기
//        // 2. 해당 dto service 로 넘기기
//        // 3. 객체 생성
//        // 4. 해당 객체 => contractDao.save( '3에서 생성한 객체' ) 로 DB에 저장
//        // 5. 결과 값 Vo객체 생성해 return  ex) "보험계약이 완료되었습니다"
//
//        return ResponseEntity.ok(new BaseResponse(contractService.createContract(postContractDto)));
//    }



    /**
     * 보험 계약을 해지한다.
     * */

    /**
     * 보험 계약을 체결한다.
     * */



}
