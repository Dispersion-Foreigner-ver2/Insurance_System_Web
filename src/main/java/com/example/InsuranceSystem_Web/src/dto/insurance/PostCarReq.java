package com.example.InsuranceSystem_Web.src.dto.insurance;

import com.example.InsuranceSystem_Web.src.entity.insurance.CarInsurance;
import com.example.InsuranceSystem_Web.src.entity.insurance.Insurance;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor
public class PostCarReq {

    // Insuracne
    @NotBlank(message = "보험이름이 공백입니다. 정확히 입력해주세요.")
    private String name;
    @NotBlank(message = "explanation을 입력해주세요.")
    private String explanation;
    @NotNull(message = "premium을 입력해주세요.")
    private int premium;

    // CarInsurance
    @NotNull
    private int humanDamageBasicMoney;
    @NotNull
    private int carDamageBasicMoney;


    public CarInsurance toEntity(){
        return CarInsurance.builder()
                .name(name)
                .explanation(explanation)
                .premium(premium)
                .authorization(true)
                .authorizationDate(LocalDateTime.now())
                .createdDate(LocalDateTime.now())
                .humanDamageBasicMoney(humanDamageBasicMoney)
                .carDamageBasicMoney(carDamageBasicMoney)
                .build();
    }

}
