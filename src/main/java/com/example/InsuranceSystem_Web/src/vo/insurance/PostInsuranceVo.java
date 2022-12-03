package com.example.InsuranceSystem_Web.src.vo.insurance;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PostInsuranceVo {
    private String message;
    private Long insuranceId;


    private String name;
}
