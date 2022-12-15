package com.example.InsuranceSystem_Web.src.dto.res.insurance;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PostInsuranceRes {
    private String message;
    private Long insuranceId;


    private String name;
}
