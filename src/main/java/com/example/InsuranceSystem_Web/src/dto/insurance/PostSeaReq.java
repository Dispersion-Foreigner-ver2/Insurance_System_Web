package com.example.InsuranceSystem_Web.src.dto.insurance;

import com.example.InsuranceSystem_Web.src.entity.insurance.Insurance;
import com.example.InsuranceSystem_Web.src.entity.insurance.SeaInsurance;
import io.swagger.models.auth.In;
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
public class PostSeaReq {

    // Insuracne
    @NotBlank(message = "보험이름이 공백입니다. 정확히 입력해주세요.")
    @NotEmpty(message = "보험이름을 입력해주세요.")
    private String name;
    @NotBlank
    @NotEmpty(message = "explanation을 입력해주세요.")
    private String explanation;
    @NotNull(message = "premium을 입력해주세요.")
    private int premium;

    // SealInsurance
    @NotNull
    private int generalDamageBasicMoney;
    @NotNull
    private int revenueDamageBasicMoney;


    public SeaInsurance toEntity(){
        return SeaInsurance.builder()
                .name(name)
                .explanation(explanation)
                .premium(premium)
                .authorization(true)
                .authorizationDate(LocalDateTime.now())
                .createdDate(LocalDateTime.now())
                .generalDamageBasicMoney(generalDamageBasicMoney)
                .revenueDamageBasicMoney(revenueDamageBasicMoney)
                .build();
    }
}
