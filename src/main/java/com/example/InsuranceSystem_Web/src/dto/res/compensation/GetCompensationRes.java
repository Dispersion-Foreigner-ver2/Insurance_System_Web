package com.example.InsuranceSystem_Web.src.dto.res.compensation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetCompensationRes {
    private Long contractId;
    private Long insuranceId;
    private String insuranceName;
    private String insuranceType;
    private String message;

//    public static GetCompensationVo of(Contract contract){
//        return GetCompensationVo.builder()
//                .contractId(contract.getContractId())
//                .insuranceId(contract.getInsurance().getId())
//                .insuranceName(contract.getInsurance().getName())
//                .insuranceType(contract.getInsurance().)
////                .insuranceType(insurance.)
//                .message("보상 신청할 계약 ID를 입력해 주세요.")
//                .build();
//    }
}
