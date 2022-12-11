package com.example.InsuranceSystem_Web.src.vo.compensation;

import com.example.InsuranceSystem_Web.src.dto.insurance.PostFireInsuranceDto;
import com.example.InsuranceSystem_Web.src.entity.insurance.FireInsurance;
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
    private int buildingDamageBasicMoney;
    private int humanDamageBasicMoney;
    private int surroundingDamageBasicMoney;
    private String message;

    public static PostCompensationAmountVo of(PostFireInsuranceDto postFireInsuranceDto){
        return PostCompensationAmountVo.builder()
                .buildingDamageBasicMoney(postFireInsuranceDto.getBuildingDamageBasicMoney())
                .humanDamageBasicMoney(postFireInsuranceDto.getHumanDamageBasicMoney())
                .surroundingDamageBasicMoney(postFireInsuranceDto.getSurroundingDamageBasicMoney())
                .message("입력하신 정보로 보상금 계싼을 하시겠습니까?")
                .build();
    }






}
