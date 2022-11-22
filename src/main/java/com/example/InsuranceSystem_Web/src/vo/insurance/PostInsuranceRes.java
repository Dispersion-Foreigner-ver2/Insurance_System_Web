package com.example.InsuranceSystem_Web.src.vo.insurance;

import com.example.InsuranceSystem_Web.src.entity.Insurance.Insurance;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PostInsuranceRes {
    private String message;
    private int insuranceId;

    private String name;
    private Insurance.Type type;
}
