package com.example.InsuranceSystem_Web.src.service.insurance;

import com.example.InsuranceSystem_Web.src.vo.insurance.PostInsuranceRes;
import com.example.InsuranceSystem_Web.src.dto.insurance.PostCarInsuranceDto;
import com.example.InsuranceSystem_Web.src.dto.insurance.PostFireInsuranceDto;
import com.example.InsuranceSystem_Web.src.dto.insurance.PostSeaInsuranceDto;

public interface InsuranceService {

    PostInsuranceRes createInsuranceCar(PostCarInsuranceDto postCarRequest);
    PostInsuranceRes createInsuranceFire(PostFireInsuranceDto postFireRequest);
    PostInsuranceRes createInsuranceSea(PostSeaInsuranceDto postSeaRequest);
}
