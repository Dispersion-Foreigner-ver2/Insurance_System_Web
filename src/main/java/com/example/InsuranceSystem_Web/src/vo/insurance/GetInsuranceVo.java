package com.example.InsuranceSystem_Web.src.vo.insurance;

import com.example.InsuranceSystem_Web.src.entity.insurance.Insurance;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetInsuranceVo {
    private Insurance insurance;
    private String insuranceType;
}
