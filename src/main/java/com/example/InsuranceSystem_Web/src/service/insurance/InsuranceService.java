package com.example.InsuranceSystem_Web.src.service.insurance;

import com.example.InsuranceSystem_Web.src.dto.req.insurance.PostCarInsuranceReq;
import com.example.InsuranceSystem_Web.src.dto.req.insurance.PostFireInsuranceReq;
import com.example.InsuranceSystem_Web.src.dto.req.insurance.PostSeaInsuranceReq;
import com.example.InsuranceSystem_Web.src.dto.res.insurance.DeleteInsuranceRes;
import com.example.InsuranceSystem_Web.src.dto.res.insurance.GetInsuranceCountRes;
import com.example.InsuranceSystem_Web.src.dto.res.insurance.PostInsuranceRes;

public interface InsuranceService {

    PostInsuranceRes createInsuranceCar(PostCarInsuranceReq postCarRequest);
    PostInsuranceRes createInsuranceFire(PostFireInsuranceReq postFireRequest);
    PostInsuranceRes createInsuranceSea(PostSeaInsuranceReq postSeaRequest);

    PostInsuranceRes setAuthorize(Long insuranceId);
    GetInsuranceCountRes readInsuranceCount();

    DeleteInsuranceRes deleteInsurance(Long insuranceId);

    Object readInsurance();
    Object readDetailInsurance(Long insuranceId);
}
