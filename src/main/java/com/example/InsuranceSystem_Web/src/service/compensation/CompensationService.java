package com.example.InsuranceSystem_Web.src.service.compensation;

import com.example.InsuranceSystem_Web.src.dto.compensation.PostCarDisclaimerDto;
import com.example.InsuranceSystem_Web.src.dto.insurance.PostFireInsuranceDto;
import com.example.InsuranceSystem_Web.src.vo.compensation.GetCompensationVo;
import com.example.InsuranceSystem_Web.src.vo.compensation.PostCarDisclaimerVo;
import com.example.InsuranceSystem_Web.src.vo.compensation.PostCompensationAmountVo;

import java.util.List;

public interface CompensationService {

    List<GetCompensationVo> compensation(Long customerId);
    PostCompensationAmountVo compensationAmount(PostFireInsuranceDto postFireInsuranceDto );
    PostCarDisclaimerVo carDisclaimer(PostCarDisclaimerDto postCarDisclaimerDto);
}
