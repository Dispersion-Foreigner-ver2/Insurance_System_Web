package com.example.InsuranceSystem_Web.src.controller;

import com.example.InsuranceSystem_Web.config.BaseResponse;
import com.example.InsuranceSystem_Web.src.service.contract.ContractService;
import io.swagger.annotations.Api;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
    @PostMapping("/create")
    public ResponseEntity<?> createContract(){
        // * postman으로 api 실행할때 =>  https://testmanager.tistory.com/342
        // * delete 폴더는 예전 코드들임
        // 1. dto 만들어서 보험 계약에 필요한 정보 받아오기
        // 2. 해당 dto service 로 넘기기
        // 3. 객체 생성
        // 4. 해당 객체 => contractDao.save( '3에서 생성한 객체' ) 로 DB에 저장
        // 5. 결과 값 Vo객체 생성해 return  ex) "보험계약이 완료되었습니다"

        return ResponseEntity.ok(new BaseResponse(contractService.createContract()));
    }

    /**
     * 보험 계약을 해지한다.
     * */

    /**
     * 보험 계약을 체결한다.
     * */



}
