package com.example.InsuranceSystem_Web.src.insurance.dto;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PostInsuranceRequest {

    @NotNull
    private int type;
//    @Email
//    private String email;  // test

    @NotNull
    private String name;
    @NotNull
    private String explanation;
    @NotNull
    private int premium;

    // CarInsurance
    @NotNull
    private int humanDamageBasicMoney;
    @NotNull
    private int carDamageBasicMoney;

    // FireInsurance
    @NotNull
    private int surroundingDamageBasicMoney;
    @NotNull
    private int buildingDamageBasicMoney;

    // SealInsurance
    @NotNull
    private int generalDamageBasicMoney;
    @NotNull
    private int revenueDamageBasicMoney;
}
