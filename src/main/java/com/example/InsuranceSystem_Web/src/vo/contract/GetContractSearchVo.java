package com.example.InsuranceSystem_Web.src.vo.contract;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetContractSearchVo {
    private String message;

    private Long contractId;
    private Long customerId;
    private String customerName;
    private Long customerInsuranceId;
    private String customerInsuranceName;

}
