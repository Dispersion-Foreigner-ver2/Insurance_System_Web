package com.example.InsuranceSystem_Web.src.vo.compensation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostCompensationAmountVo {
    private int brokenState;
    private int humanDamage;
    private int surroundingDamage;
    private String message;






}
