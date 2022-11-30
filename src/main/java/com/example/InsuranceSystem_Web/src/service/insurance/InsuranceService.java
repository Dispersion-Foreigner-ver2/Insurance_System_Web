package com.example.InsuranceSystem_Web.src.service.insurance;

import com.example.InsuranceSystem_Web.src.vo.insurance.*;
import com.example.InsuranceSystem_Web.src.dto.insurance.*;

public interface InsuranceService {

    PostInsuranceVo createInsuranceCar(PostCarInsuranceDto postCarRequest);
    PostInsuranceVo createInsuranceFire(PostFireInsuranceDto postFireRequest);
    PostInsuranceVo createInsuranceSea(PostSeaInsuranceDto postSeaRequest);

    PostInsuranceVo setAuthorize(Long insuranceId);
    GetInsuranceCountVo readInsuranceCount();

    DeleteInsuranceVo deleteInsurance(Long insuranceId);

    Object readInsurance();
    Object readDetailInsurance(Long insuranceId);
}
