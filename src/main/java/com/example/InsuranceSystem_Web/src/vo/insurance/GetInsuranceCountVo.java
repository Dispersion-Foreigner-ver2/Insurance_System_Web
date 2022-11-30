package com.example.InsuranceSystem_Web.src.vo.insurance;

import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetInsuranceCountVo {
    private int insuranceSum;
    private int authInsuranceSum;
    private int authNotInsuranceSum;
}
