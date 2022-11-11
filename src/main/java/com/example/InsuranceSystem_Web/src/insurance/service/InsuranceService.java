package com.example.InsuranceSystem_Web.src.insurance.service;

import com.example.InsuranceSystem_Web.src.insurance.dto.PostInsuranceRequest;
import com.example.InsuranceSystem_Web.src.insurance.entity.Insurance;

public interface InsuranceService {
    public Insurance design(PostInsuranceRequest postInsuranceRequest);
}
