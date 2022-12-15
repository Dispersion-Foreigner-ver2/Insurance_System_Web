package com.example.InsuranceSystem_Web.src.service.compensation;

import com.example.InsuranceSystem_Web.src.dto.req.compensation.PostCarDisclaimerReq;
import com.example.InsuranceSystem_Web.src.dto.req.insurance.PostFireInsuranceReq;
import com.example.InsuranceSystem_Web.src.dto.res.compensation.GetCompensationRes;
import com.example.InsuranceSystem_Web.src.dto.res.compensation.PostCarDisclaimerRes;
import com.example.InsuranceSystem_Web.src.dto.res.compensation.PostCompensationAmountRes;

import java.util.List;

public interface CompensationService {

    List<GetCompensationRes> compensation(Long customerId);
    PostCompensationAmountRes compensationAmount(PostFireInsuranceReq postFireInsuranceDto );
    PostCarDisclaimerRes carDisclaimer(PostCarDisclaimerReq postCarDisclaimerDto);
}
