package com.example.InsuranceSystem_Web.src.vo.contract;

import com.example.InsuranceSystem_Web.src.entity.insurance.Insurance;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostContractConclusionVo {
    private String message;
    private Long contractId;
}
