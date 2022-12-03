package com.example.InsuranceSystem_Web.src.dto.contract;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
public class PostContractDto {
    @NotBlank(message = "계약을 진행 할 보험 ID를 입력해 주세요.")
    private Long insuranceId;
}
