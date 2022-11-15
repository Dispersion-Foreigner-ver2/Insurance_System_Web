package com.example.InsuranceSystem_Web.src.insurance.service;

import com.example.InsuranceSystem_Web.src.insurance.dto.*;
import com.example.InsuranceSystem_Web.src.insurance.vo.PostInsuranceRes;

public interface InsuranceService {

    PostInsuranceRes createInsuranceCar(PostCarReq postCarRequest);
    PostInsuranceRes createInsuranceFire(PostFireReq postFireRequest);
    PostInsuranceRes createInsuranceSea(PostSeaReq postSeaRequest);
}
