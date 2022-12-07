package com.example.InsuranceSystem_Web.src.controller;

import com.example.InsuranceSystem_Web.config.BaseResponse;
import com.example.InsuranceSystem_Web.src.dto.contract.PostContractDto;
import com.example.InsuranceSystem_Web.src.dto.contract.*;
import com.example.InsuranceSystem_Web.src.service.contract.ContractService;
import io.swagger.annotations.Api;
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

    @GetMapping("/contract")
    public ResponseEntity<?> contractManage(){
        return ResponseEntity.ok(new BaseResponse(contractService.contractManage()));
    }


    /**
     * 보험 계약을 관리한다.
     * -  모든 계약 보기
     * */
    @GetMapping("/contract/all")
    public ResponseEntity<?> getContractLis(){
        return ResponseEntity.ok(new BaseResponse(contractService.getContractList()));
    }

    /**
     * 보험 계약을 관리한다 .
     * - 해당 고객의 계약 모두 보기
     *   http://localhost:8080/contract/search/all?id=125
     * */
    @GetMapping("/contract/search/all")
    public ResponseEntity<?> contractSearchAll(@RequestParam("id") Long customerId){
        return ResponseEntity.ok(new BaseResponse(contractService.contractSearchAll(customerId)));
    }

    /**
     * 보험 계약을 관리한다 .
     * - 특정 계약 검색하기
     *   http://localhost:8080/contract/search?id=1
     * */
    @GetMapping("/contract/search")
    public ResponseEntity<?> contractSearch(@RequestParam("id") Long contractId){
        return ResponseEntity.ok(new BaseResponse(contractService.contractSearch(contractId)));
    }


    /**
     * 보험 계약을 해지한다.
     * */
    @DeleteMapping("/contract/terminate")
    public ResponseEntity<?> contractTerminate(@RequestParam("id") Long contractId){
        return ResponseEntity.ok(new BaseResponse(contractService.contractTerminate(contractId)));
    }


    /**
     * 보험 계약을 체결한다. - 화재보험
     * */
    @PostMapping("/contract/conclusion/fire")
    public ResponseEntity<?> contractConclusionFire(PostFireContractDto postContractDto){
        return ResponseEntity.ok(new BaseResponse(contractService.contractConclusion(postContractDto)));
    }

    /**
     * 보험 계약을 체결한다. - 자동차 보험
     * */
    @PostMapping("/contract/conclusion/car")
    public ResponseEntity<?> contractConclusionCar(PostCarContractDto postContractDto){
        return ResponseEntity.ok(new BaseResponse(contractService.contractConclusion(postContractDto)));
    }

    /**
     * 보험 계약을 체결한다. - 헤상 보험
     * */
    @PostMapping("/contract/conclusion/sea")
    public ResponseEntity<?> contractConclusionSea(PostSeaContractDto postContractDto){
        return ResponseEntity.ok(new BaseResponse(contractService.contractConclusion(postContractDto)));
    }


    /**
     * 인수 심사를 관리한다.
     * - 전체 계약의 인수심사 보여주기
     * */
    @GetMapping("/contract/under-write/all")
    public ResponseEntity<?> getUnderWriteAll(){
        return ResponseEntity.ok(new BaseResponse(contractService.getUnderWriteAll()));
    }

    /**
     * 인수 심사를 관리한다.
     * - 고객 별 인수 심사 현황
     * */
    @GetMapping("/contract/under-write/customer")
    public ResponseEntity<?> getUnderWrites(@RequestParam("id") Long customerId){
        return ResponseEntity.ok(new BaseResponse(contractService.getUnderWrites(customerId)));
    }

    /**
     * 인수 심사를 수행한다
     * - 특정 계약의 인수심사 확인
     * http://localhost:8080/contract/under-write/3
     * */
    @GetMapping("/contract/under-write/{contractId}")
    public ResponseEntity<?> getUnderWrite(@PathVariable("contractId") Long contractId){
        return ResponseEntity.ok(new BaseResponse(contractService.getUnderWrite(contractId)));
    }


    /**
     * 인수 심사를 수행한다.
     *  http://localhost:8080/contract/under-write/3
     * */
    @PostMapping("/contract/under-write/{contractId}")
    public ResponseEntity<?> updateUnderWrite(@PathVariable("contractId") Long contractId){
        return ResponseEntity.ok(new BaseResponse(contractService.updateUnderWrite(contractId)));
    }

}
