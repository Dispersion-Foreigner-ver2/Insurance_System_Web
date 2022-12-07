package com.example.InsuranceSystem_Web.src.dto.compensation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostCompensationAmountDto {

    @NotBlank(message = "화재 장소 파손상태를 입력하세요.")
    private String brokenState;

    @NotBlank(message = "인적 피해를 입력하세요.")
    private String humanDamage;

    @NotBlank(message = "주변 피해 상태를 입력하세요.")
    private String surroundingDamage;

}
