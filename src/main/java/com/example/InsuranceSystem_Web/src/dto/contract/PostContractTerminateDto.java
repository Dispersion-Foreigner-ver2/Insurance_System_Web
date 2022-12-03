package com.example.InsuranceSystem_Web.src.dto.contract;

import com.example.InsuranceSystem_Web.src.entity.contract.Contract;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
public class PostContractTerminateDto {
    @NotBlank(message = "해지 할 계약 ID를 입력해 주세요.")
    private Long contractId;


}
