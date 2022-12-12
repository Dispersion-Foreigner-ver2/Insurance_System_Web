package com.example.InsuranceSystem_Web.src.controller;

import com.example.InsuranceSystem_Web.config.BaseException;
import com.example.InsuranceSystem_Web.config.BaseResponse;
import com.example.InsuranceSystem_Web.src.dto.contract.PostContractDto;
import com.example.InsuranceSystem_Web.src.dto.contract.*;
import com.example.InsuranceSystem_Web.src.entity.contract.Contract;
import com.example.InsuranceSystem_Web.src.exception.contract.NotFoundContractException;
import com.example.InsuranceSystem_Web.src.exception.contract.NotFoundCustomerException;
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
@RestController
@Api(tags ="2. contract API ")
@Slf4j
public class ContractController {

    private final ContractService contractService;

    /**
     * 보험 계약을 관리한다. -  보험 id, 보험 이름, 보험 종류, 보험에 가입한 고객 수
     *  @return ResponseEntity<List<PostContractManageVo>>
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
     * 보험 계약을 관리한다. -  모든 계약 보기
     *  @return ResponseEntity<List<Contract>>
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
     * 보험 계약을 관리한다 . - 해당 고객의 계약 모두 보기
     *  @param  customerId
     *  @return ResponseEntity<List<GetContractSearchVo>>
     * */
    @ApiOperation(value = "보험 계약을 관리한다. -  모든 계약 보기")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK", response = GetContractSearchVo.class),
            @ApiResponse(code = 2001, message = "등록된 고객 정보가 없습니다. 다시 시도해주시거나 회원 가입 후 진행해주세요.")
    })
    @GetMapping("/contract/search/all")
    public ResponseEntity<?> contractSearchAll(@RequestParam("customerId") @ApiParam(value = "고객 아이디",example = "0", defaultValue = "125") Long customerId){
        return ResponseEntity.ok(new BaseResponse(contractService.contractSearchAll(customerId)));
    }

    /**
     * 보험 계약을 관리한다 .- 특정 계약 검색하기
     *  @param  contractId
     *  @return ResponseEntity<GetContractSearchVo>
     * */
    @ApiOperation(value = "보험 계약을 관리한다 . - 특정 계약 검색하기")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK", response = GetContractSearchVo.class),
            @ApiResponse(code = 2000, message = "존재하지 않는 계약입니다.")
    })
    @GetMapping("/contract/search")
    public ResponseEntity<?> contractSearch(@RequestParam("contractId") @ApiParam(value = "계약 아이디",example = "0", defaultValue = "3") Long contractId){
        return ResponseEntity.ok(new BaseResponse(contractService.contractSearch(contractId)));
    }


    /**
     * 보험 계약을 해지한다.
     *  @param  contractId
     *  @return ResponseEntity<GetContractSearchVo>
     * */
    @ApiOperation(value = "보험 계약을 해지한다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK", response = DeleteContractTerminateVo.class),
            @ApiResponse(code = 2000, message = "존재하지 않는 계약입니다.")
    })
    @DeleteMapping("/contract/terminate")
    public ResponseEntity<?> contractTerminate(@RequestParam("contractId") @ApiParam(value = "계약 아이디",example = "0", defaultValue = "3") Long contractId){
        return ResponseEntity.ok(new BaseResponse(contractService.contractTerminate(contractId)));
    }


    /**
     * 보험 계약을 체결한다. - 화재보험
     *  @param  postContractDto
     *  @return ResponseEntity<PostContractConclusionVo>
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
     *  @param  postContractDto
     *  @return ResponseEntity<PostContractConclusionVo>
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
     *  @param  postContractDto
     *  @return ResponseEntity<PostContractConclusionVo>
     * */
    @ApiOperation(value = "보험 계약을 체결한다. - 해상 보험")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK", response = PostContractConclusionVo.class),
            @ApiResponse(code=2004, message="예기치 못한 오류로 보험 계약에 실패하였습니다. 계약을 다시 시도해주세요.")
    })
    @PostMapping("/contract/conclusion/sea")
    public ResponseEntity<?> contractConclusionSea(PostSeaContractDto postContractDto){
        return ResponseEntity.ok(new BaseResponse(contractService.contractConclusion(postContractDto)));
    }


    /**
     * 인수 심사를 관리한다. - 전체 계약의 인수심사 보여주기
     *  @return ResponseEntity<List<GetUnderWriteVo>>
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
     * 인수 심사를 관리한다. - 고객 별 인수 심사 현황
     *  @param  customerId
     *  @return ResponseEntity<List<GetUnderWriteVo>>
     * */
    @ApiOperation(value = "인수 심사를 관리한다. - 고객 별 인수 심사 현황")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK", response = GetUnderWriteVo.class),
            @ApiResponse(code = 2000, message = "존재하지 않는 계약입니다."),
            @ApiResponse(code = 2001, message = "등록된 고객 정보가 없습니다. 다시 시도해주시거나 회원 가입 후 진행해주세요.")
    })
    @GetMapping("/contract/under-write/customer")
    public ResponseEntity<?> getUnderWrites(@RequestParam("customerId") @ApiParam(value = "고객 아이디",example = "0", defaultValue = "133")  Long customerId){
        return ResponseEntity.ok(new BaseResponse(contractService.getUnderWrites(customerId)));
    }

    /**
     * 인수 심사를 수행한다 - 특정 계약의 인수심사 확인
     *  @pathvariable contractId
     *  @return ResponseEntity<GetUnderWriteVo>
     * */
    @ApiOperation(value = "인수 심사를 수행한다 - 특정 계약의 인수심사 확인")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK", response = GetUnderWriteVo.class),
            @ApiResponse(code = 2000, message = "존재하지 않는 계약입니다.")
    })
    @GetMapping("/contract/under-write/{contractId}")
    public ResponseEntity<?> getUnderWrite(@PathVariable("contractId") @ApiParam(value = "계약 아이디",example = "3", defaultValue = "2")  Long contractId){
        return ResponseEntity.ok(new BaseResponse(contractService.getUnderWrite(contractId)));
    }


    /**
     * 인수 심사를 수행한다.
     *  @pathvariable contractId
     *  @return ResponseEntity<UpdateUnderWriteVo>
     * */
    @ApiOperation(value = "인수 심사를 수행한다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK", response = UpdateUnderWriteVo.class),
            @ApiResponse(code = 2000, message = "존재하지 않는 계약입니다.")
    })
    @PostMapping("/contract/under-write/{contractId}")
    public ResponseEntity<?> updateUnderWrite(@PathVariable("contractId") @ApiParam(value = "계약 아이디",example = "0", defaultValue = "2") Long contractId){
        return ResponseEntity.ok(new BaseResponse(contractService.updateUnderWrite(contractId)));
    }

}
