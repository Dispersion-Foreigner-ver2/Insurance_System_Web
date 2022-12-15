package com.example.InsuranceSystem_Web.src.dto.res.insurance;

import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetInsuranceCountRes {
    private int insuranceSum;
    private int authInsuranceSum;
    private int authNotInsuranceSum;
}
