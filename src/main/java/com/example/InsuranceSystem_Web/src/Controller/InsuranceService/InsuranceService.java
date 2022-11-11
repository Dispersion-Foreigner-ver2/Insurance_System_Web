package com.example.InsuranceSystem_Web.src.Controller.InsuranceService;

import com.example.InsuranceSystem_Web.src.Controller.InsuranceService.dto.PostInsuranceRequest;
import com.example.InsuranceSystem_Web.src.Domain.Insurance.Insurance;

public interface InsuranceService {
    public Insurance design(PostInsuranceRequest postInsuranceRequest);
}
