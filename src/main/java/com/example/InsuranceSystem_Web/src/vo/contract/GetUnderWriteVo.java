package com.example.InsuranceSystem_Web.src.vo.contract;

import com.example.InsuranceSystem_Web.src.entity.contract.Contract;
import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class GetUnderWriteVo {
    private String message;

    private Long contractId;
    private Long insuranceId;
    private String insuranceName;
    private boolean underWrite;

    public static GetUnderWriteVo of(Contract contract){
        return GetUnderWriteVo.builder()
                .message(contract.getCustomer().getName()+"님의 인수 심사 현황")
                .contractId(contract.getContractId())
                .insuranceId(contract.getInsurance().getId())
                .insuranceName(contract.getInsurance().getName())
                .underWrite(contract.isUnderWrite())
                .build();
    }
}
