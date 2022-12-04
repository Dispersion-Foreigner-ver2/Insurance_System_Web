package com.example.InsuranceSystem_Web.src.controller;

import com.example.InsuranceSystem_Web.config.BaseResponse;
import com.example.InsuranceSystem_Web.src.service.contract.ContractService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/contractManage")
    public ResponseEntity<?> contractManage(){
        return ResponseEntity.ok(new BaseResponse(contractService.contractManage()));
    }

    /**
     * 보험 계약을 검색한다.
     * */

    //get과 post의 차이 = get은 read // post 는 create, update, 수정...

    @GetMapping("/contractSearch")
    public ResponseEntity<?> contractSearch(@RequestParam("cusotmerid") Long customerId){
        return ResponseEntity.ok(new BaseResponse(contractService.contractSearch(customerId)));
    }


    /**
     * 보험 계약을 해지한다.
     * */
    @PostMapping("/contractTerminate")
    public ResponseEntity<?> contractTerminate(@RequestParam("id") Long contractId){
        return ResponseEntity.ok(new BaseResponse(contractService.contractTerminate(contractId)));
    }



    /**
     * 보험 계약을 체결한다.
     * */
//    @PostMapping("/contract")
//    public ResponseEntity<?> contract(@RequestParam("id") Long insuranceId){
//        return ResponseEntity.ok(new BaseResponse(contractService.contract(insuranceId)));
//    }

    @PostMapping("/contract/Conclusion")
    public ResponseEntity<?> contractConclusion(Long insuranceId   ){
        return ResponseEntity.ok(new BaseResponse(contractService.contractConclusion(insuranceId)));
    }




}
