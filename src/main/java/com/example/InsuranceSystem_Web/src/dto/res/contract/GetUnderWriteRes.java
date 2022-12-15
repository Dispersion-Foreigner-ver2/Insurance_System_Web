package com.example.InsuranceSystem_Web.src.dto.res.contract;

import com.example.InsuranceSystem_Web.src.entity.contract.Contract;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class GetUnderWriteRes {
    @ApiModelProperty(example = "--님의 인수 심사 현황")
    private String message;

    private Long contractId;
    private Long insuranceId;
    private String insuranceName;
    private boolean underWrite;

    public static GetUnderWriteRes of(Contract contract){
        return GetUnderWriteRes.builder()
                .message(contract.getCustomer().getName()+"님의 인수 심사 현황")
                .contractId(contract.getContractId())
                .insuranceId(contract.getInsurance().getId())
                .insuranceName(contract.getInsurance().getName())
                .underWrite(contract.isUnderWrite())
                .build();
    }
}
