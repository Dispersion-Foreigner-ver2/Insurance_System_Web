package com.example.InsuranceSystem_Web.src.dto.insurance;

import com.example.InsuranceSystem_Web.src.entity.insurance.FireInsurance;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor
public class PostFireInsuranceDto {

    @NotBlank(message = "보험이름이 공백입니다. 정확히 입력해주세요.")
    private String name;
    @NotBlank(message = "보험 설명을 입력해주세요.")
    private String explanation;
    @NotNull(message = "보험료를 입력해주세요.")
    private int premium;

    @NotNull(message = "주변 피해 보상금을 입력해주세요.")
    private int surroundingDamageBasicMoney;
    @NotNull(message = "인적 피해 보상금을 입력해주세요.")
    private int humanDamageBasicMoney;
    @NotNull(message = "건물 피해 보상금을 입력해주세요.")
    private int buildingDamageBasicMoney;


    public FireInsurance toEntity(){
        return FireInsurance.builder()
                .name(name)
                .explanation(explanation)
                .premium(premium)
                .authorization(true)
                .authorizationDate(LocalDateTime.now())
                .createdDate(LocalDateTime.now())
                .surroundingDamageBasicMoney(surroundingDamageBasicMoney)
                .humanDamageBasicMoney(humanDamageBasicMoney)
                .buildingDamageBasicMoney(buildingDamageBasicMoney)
                .build();
    }

}
