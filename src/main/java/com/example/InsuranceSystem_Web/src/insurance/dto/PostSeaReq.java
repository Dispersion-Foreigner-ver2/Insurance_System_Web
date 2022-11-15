package com.example.InsuranceSystem_Web.src.insurance.dto;

import com.example.InsuranceSystem_Web.src.insurance.entity.CarInsurance;
import com.example.InsuranceSystem_Web.src.insurance.entity.Insurance;
import com.example.InsuranceSystem_Web.src.insurance.entity.SeaInsurance;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PostSeaReq {

    // Insuracne
    @NotNull
    private String name;
    @NotNull
    private String explanation;
    @NotNull
    private int premium;

    // SealInsurance
    @NotNull
    private int generalDamageBasicMoney;
    @NotNull
    private int revenueDamageBasicMoney;

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

    public SeaInsurance toEntity(Insurance insurance){
        return SeaInsurance.builder()
                .generalDamageBasicMoney(generalDamageBasicMoney)
                .revenueDamageBasicMoney(revenueDamageBasicMoney)
                .insurance(insurance)
                .build();
    }
}
