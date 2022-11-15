package com.example.InsuranceSystem_Web.src.insurance.dto;

import com.example.InsuranceSystem_Web.src.insurance.entity.CarInsurance;
import com.example.InsuranceSystem_Web.src.insurance.entity.Insurance;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
public class PostCarReq {

    // Insuracne
    @NotBlank(message = "보험이름이 공백입니다. 정확히 입력해주세요.")
    @NotEmpty(message = "보험이름을 입력해주세요.")
    private String name;
    @NotBlank
    @NotEmpty(message = "explanation을 입력해주세요.")
    private String explanation;
    @NotNull(message = "premium을 입력해주세요.")
    private int premium;

    // CarInsurance
    @NotNull
    private int humanDamageBasicMoney;
    @NotNull
    private int carDamageBasicMoney;

    public Insurance of(Insurance.Type type){
        return Insurance.of(name, explanation,premium,type);
    }

    public CarInsurance toEntity(Insurance insurance){
        return CarInsurance.builder()
                .humanDamageBasicMoney(humanDamageBasicMoney)
                .carDamageBasicMoney(carDamageBasicMoney)
                .insurance(insurance)
                .build();
    }

}
