package com.example.InsuranceSystem_Web.src.insurance.dto;

import com.example.InsuranceSystem_Web.src.insurance.entity.CarInsurance;
import com.example.InsuranceSystem_Web.src.insurance.entity.FireInsurance;
import com.example.InsuranceSystem_Web.src.insurance.entity.Insurance;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PostFireReq {

    // Insuracne
    @NotNull
    private String name;
    @NotNull
    private String explanation;
    @NotNull
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
