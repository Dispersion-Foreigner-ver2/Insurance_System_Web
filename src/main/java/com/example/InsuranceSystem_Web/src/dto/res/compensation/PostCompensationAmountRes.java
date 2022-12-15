package com.example.InsuranceSystem_Web.src.dto.res.compensation;

import com.example.InsuranceSystem_Web.src.dto.req.insurance.PostFireInsuranceReq;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostCompensationAmountRes {
    private int buildingDamageBasicMoney;
    private int humanDamageBasicMoney;
    private int surroundingDamageBasicMoney;
    private String message;

    public static PostCompensationAmountRes of(PostFireInsuranceReq postFireInsuranceDto){
        return PostCompensationAmountRes.builder()
                .buildingDamageBasicMoney(postFireInsuranceDto.getBuildingDamageBasicMoney())
                .humanDamageBasicMoney(postFireInsuranceDto.getHumanDamageBasicMoney())
                .surroundingDamageBasicMoney(postFireInsuranceDto.getSurroundingDamageBasicMoney())
                .message("입력하신 정보로 보상금 계싼을 하시겠습니까?")
                .build();
    }






}
