package com.example.InsuranceSystem_Web.src.vo.insurance;

import com.example.InsuranceSystem_Web.src.entity.insurance.Insurance;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PostInsuranceRes {
    private String message;
    private Long insuranceId;

    private String name;
}
