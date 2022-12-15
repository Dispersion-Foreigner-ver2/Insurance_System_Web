package com.example.InsuranceSystem_Web.src.dto.res.contract;

import com.example.InsuranceSystem_Web.src.entity.contract.Contract;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetContractSearchRes {
    private String message;

    private Long contractId;
    private Long customerId;
    private String customerName;
    private Long customerInsuranceId;
    private String customerInsuranceName;

    public static GetContractSearchRes of(Contract contract){
        return GetContractSearchRes.builder()
                .contractId(contract.getContractId())
                .customerId(contract.getCustomer().getId())
                .customerName(contract.getCustomer().getName())
                .customerInsuranceId(contract.getInsurance().getId())
                .customerInsuranceName(contract.getInsurance().getName())
                .build();
    }

}
