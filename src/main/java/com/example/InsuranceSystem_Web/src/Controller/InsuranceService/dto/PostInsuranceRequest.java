package com.example.InsuranceSystem_Web.src.Controller.InsuranceService.dto;

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
    @Email
    private String email;  // test

//    private String name;
//    private String explanation;
//    private int premium;
//
//    // CarInsurance
//    private int humanDamageBasicMoney;
//    private int carDamageBasicMoney;
//
//    // FireInsurance
//    private int surroundingDamageBasicMoney;
//    private int buildingDamageBasicMoney;
//
//    // SealInsurance
//    private int generalDamageBasicMoney;
//    private int revenueDamageBasicMoney;
}
