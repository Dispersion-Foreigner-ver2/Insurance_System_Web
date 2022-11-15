package com.example.InsuranceSystem_Web.src.insurance.dto;

import com.example.InsuranceSystem_Web.src.insurance.entity.CarInsurance;
import com.example.InsuranceSystem_Web.src.insurance.entity.FireInsurance;
import com.example.InsuranceSystem_Web.src.insurance.entity.Insurance;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PostFireReq {

    // Insuracne
    @NotBlank(message = "보험이름이 공백입니다. 정확히 입력해주세요.")
    @NotEmpty(message = "보험이름을 입력해주세요.")
    private String name;
    @NotBlank
    @NotEmpty(message = "explanation을 입력해주세요.")
    private String explanation;
    @NotNull(message = "premium을 입력해주세요.")
    private int premium;

    // FireInsurance
    @NotNull
    private int surroundingDamageBasicMoney;
    @NotNull
    private int humanDamageBasicMoney;
    @NotNull
    private int buildingDamageBasicMoney;

    public Insurance toInsuranceEntity(Insurance.Type type){
        return Insurance.builder()
                .name(name)
                .explanation(explanation)
                .premium(premium)
                .authorization(true)
                .authorizationDate(LocalDateTime.now())
                .createdDate(LocalDateTime.now())
                .type(type)
                .build();
    }

    public FireInsurance toEntity(Insurance insurance){
        return FireInsurance.builder()
                .surroundingDamageBasicMoney(surroundingDamageBasicMoney)
                .humanDamageBasicMoney(humanDamageBasicMoney)
                .buildingDamageBasicMoney(buildingDamageBasicMoney)
                .insurance(insurance)
                .build();
    }

}
