package com.example.InsuranceSystem_Web.src.controller;

import com.example.InsuranceSystem_Web.config.BaseResponse;
import com.example.InsuranceSystem_Web.src.dto.contract.PostContractDto;
import com.example.InsuranceSystem_Web.src.dto.contract.*;
import com.example.InsuranceSystem_Web.src.entity.contract.Contract;
import com.example.InsuranceSystem_Web.src.service.contract.ContractService;
import com.example.InsuranceSystem_Web.src.vo.contract.*;
import com.example.InsuranceSystem_Web.src.vo.insurance.PostInsuranceVo;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Controller
@Api(tags ="2. contract API ")
@Slf4j
public class ContractController {

    private final ContractService contractService;

    /**
     * 보험 계약을 관리한다.
     * -  보험 id, 보험 이름, 보험 종류, 보험에 가입한 고객 수
     *   http://localhost:8080/contract
     * */
    @ApiOperation(value = "보험 계약을 관리한다. -  보험 id, 보험 이름, 보험 종류, 보험에 가입한 고객 수")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK", response = PostContractManageVo.class)
    })
    @GetMapping("/contract")
    public ResponseEntity<?> contractManage(){
        return ResponseEntity.ok(new BaseResponse(contractService.contractManage()));
    }

    /**
     * 보험 계약을 관리한다.
     * -  모든 계약 보기
     * */
    @ApiOperation(value = "보험 계약을 관리한다. -  모든 계약 보기")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK", response = Contract.class)
    })
    @GetMapping("/contract/all")
    public ResponseEntity<?> getContractLis(){
        return ResponseEntity.ok(new BaseResponse(contractService.getContractList()));
    }

    /**
     * 보험 계약을 관리한다 .
     * - 해당 고객의 계약 모두 보기
     *   http://localhost:8080/contract/search/all?customer-id=125
     * */
    @ApiOperation(value = "보험 계약을 관리한다. -  모든 계약 보기")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK", response = GetContractSearchVo.class)
    })
    @GetMapping("/contract/search/all")
    public ResponseEntity<?> contractSearchAll(@RequestParam("customer-id") @ApiParam(value = "고객 아이디",example = "0", defaultValue = "125") Long customerId){
        return ResponseEntity.ok(new BaseResponse(contractService.contractSearchAll(customerId)));
    }

    /**
     * 보험 계약을 관리한다 .
     * - 특정 계약 검색하기
     *   http://localhost:8080/contract/search?contract-id=1
     * */
    @ApiOperation(value = "보험 계약을 관리한다 . - 특정 계약 검색하기")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK", response = GetContractSearchVo.class)
    })
    @GetMapping("/contract/search")
    public ResponseEntity<?> contractSearch(@RequestParam("contract-id") @ApiParam(value = "계약 아이디",example = "0", defaultValue = "3") Long contractId){
        return ResponseEntity.ok(new BaseResponse(contractService.contractSearch(contractId)));
    }


    /**
     * 보험 계약을 해지한다.
     * */
    @ApiOperation(value = "보험 계약을 해지한다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK", response = DeleteContractTerminateVo.class)
    })
    @DeleteMapping("/contract/terminate")
    public ResponseEntity<?> contractTerminate(@RequestParam("contract-id") @ApiParam(value = "계약 아이디",example = "0", defaultValue = "3") Long contractId){
        return ResponseEntity.ok(new BaseResponse(contractService.contractTerminate(contractId)));
    }


    /**
     * 보험 계약을 체결한다. - 화재보험
     * */
    @ApiOperation(value = "보험 계약을 체결한다. - 화재보험")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK", response = PostContractConclusionVo.class)
    })
    @PostMapping("/contract/conclusion/fire")
    public ResponseEntity<?> contractConclusionFire(PostFireContractDto postContractDto){
        return ResponseEntity.ok(new BaseResponse(contractService.contractConclusion(postContractDto)));
    }

    /**
     * 보험 계약을 체결한다. - 자동차 보험
     * */
    @ApiOperation(value = "보험 계약을 체결한다. - 자동차 보험")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK", response = PostContractConclusionVo.class)
    })
    @PostMapping("/contract/conclusion/car")
    public ResponseEntity<?> contractConclusionCar(PostCarContractDto postContractDto){
        return ResponseEntity.ok(new BaseResponse(contractService.contractConclusion(postContractDto)));
    }

    /**
     * 보험 계약을 체결한다. - 해상 보험
     * */
    @ApiOperation(value = "보험 계약을 체결한다. - 해상 보험")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK", response = PostContractConclusionVo.class)
    })
    @PostMapping("/contract/conclusion/sea")
    public ResponseEntity<?> contractConclusionSea(PostSeaContractDto postContractDto){
        return ResponseEntity.ok(new BaseResponse(contractService.contractConclusion(postContractDto)));
    }


    /**
     * 인수 심사를 관리한다.
     * - 전체 계약의 인수심사 보여주기
     * */
    @ApiOperation(value = "인수 심사를 관리한다.-  전체 계약의 인수심사 보여주기")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK", response = GetUnderWriteVo.class)
    })
    @GetMapping("/contract/under-write/all")
    public ResponseEntity<?> getUnderWriteAll(){
        return ResponseEntity.ok(new BaseResponse(contractService.getUnderWriteAll()));
    }

    /**
     * 인수 심사를 관리한다.
     * - 고객 별 인수 심사 현황
     * */
    @ApiOperation(value = "인수 심사를 관리한다. - 고객 별 인수 심사 현황")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK", response = GetUnderWriteVo.class)
    })
    @GetMapping("/contract/under-write/customer")
    public ResponseEntity<?> getUnderWrites(@RequestParam("customer-id") @ApiParam(value = "고객 아이디",example = "0", defaultValue = "133")  Long customerId){
        return ResponseEntity.ok(new BaseResponse(contractService.getUnderWrites(customerId)));
    }

    /**
     * 인수 심사를 수행한다
     * - 특정 계약의 인수심사 확인
     * http://localhost:8080/contract/under-write/3
     * */
    @ApiOperation(value = "인수 심사를 수행한다 - 특정 계약의 인수심사 확인")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK", response = GetUnderWriteVo.class)
    })
    @GetMapping("/contract/under-write/{contractId}")
    public ResponseEntity<?> getUnderWrite(@PathVariable("contractId") @ApiParam(value = "계약 아이디",example = "3", defaultValue = "2")  Long contractId){
        return ResponseEntity.ok(new BaseResponse(contractService.getUnderWrite(contractId)));
    }


    /**
     * 인수 심사를 수행한다.
     *  http://localhost:8080/contract/under-write/3
     * */
    @ApiOperation(value = "인수 심사를 수행한다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK", response = UpdateUnderWriteVo.class)
    })
    @PostMapping("/contract/under-write/{contractId}")
    public ResponseEntity<?> updateUnderWrite(@PathVariable("contractId") @ApiParam(value = "계약 아이디",example = "0", defaultValue = "2") Long contractId){
        return ResponseEntity.ok(new BaseResponse(contractService.updateUnderWrite(contractId)));
    }

}
