package com.example.InsuranceSystem_Web.src.service.insurance;

import com.example.InsuranceSystem_Web.src.vo.insurance.PostInsuranceRes;
import com.example.InsuranceSystem_Web.src.dto.insurance.PostCarReq;
import com.example.InsuranceSystem_Web.src.dto.insurance.PostFireReq;
import com.example.InsuranceSystem_Web.src.dto.insurance.PostSeaReq;

public interface InsuranceService {

    PostInsuranceRes createInsuranceCar(PostCarReq postCarRequest);
    PostInsuranceRes createInsuranceFire(PostFireReq postFireRequest);
    PostInsuranceRes createInsuranceSea(PostSeaReq postSeaRequest);
}
