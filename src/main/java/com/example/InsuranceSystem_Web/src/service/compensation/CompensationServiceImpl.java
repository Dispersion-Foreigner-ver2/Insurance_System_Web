package com.example.InsuranceSystem_Web.src.service.compensation;

import com.example.InsuranceSystem_Web.src.dao.contract.ContractDao;
import com.example.InsuranceSystem_Web.src.dao.customer.CustomerDao;
import com.example.InsuranceSystem_Web.src.dao.insurance.FireInsuranceDao;
import com.example.InsuranceSystem_Web.src.dao.insurance.InsuranceDao;
import com.example.InsuranceSystem_Web.src.dto.compensation.PostCarDisclaimerDto;
import com.example.InsuranceSystem_Web.src.dto.compensation.PostCompensationAmountDto;
import com.example.InsuranceSystem_Web.src.dto.insurance.PostFireInsuranceDto;
import com.example.InsuranceSystem_Web.src.entity.contract.Contract;
import com.example.InsuranceSystem_Web.src.entity.customer.Customer;
import com.example.InsuranceSystem_Web.src.entity.insurance.CarInsurance;
import com.example.InsuranceSystem_Web.src.entity.insurance.FireInsurance;
import com.example.InsuranceSystem_Web.src.entity.insurance.Insurance;
import com.example.InsuranceSystem_Web.src.vo.compensation.GetCompensationVo;
import com.example.InsuranceSystem_Web.src.vo.compensation.PostCarDisclaimerVo;
import com.example.InsuranceSystem_Web.src.vo.compensation.PostCompensationAmountVo;
import com.example.InsuranceSystem_Web.src.vo.contract.PostContractManageVo;
import com.example.InsuranceSystem_Web.src.vo.insurance.GetInsuranceVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Slf4j
public class CompensationServiceImpl implements CompensationService {

    private final ContractDao contractDao;


    @Override
    public List<GetCompensationVo> compensation(Long customerId) {
        List<Contract> contractList=contractDao.findByCustomerId(customerId);
        List<GetCompensationVo> getCompensationVoList= new ArrayList<>();

        for (int i = 0; i < contractList.size(); i++) {

            String type;
            if (contractList.get(i).getInsurance() instanceof CarInsurance) {
                type = "C";
            } else if (contractList.get(i).getInsurance() instanceof FireInsurance) {
                type = "F";
            } else {
                type = "S";
            }
            GetCompensationVo getCompensationVo = GetCompensationVo.builder()
                    .contractId(contractList.get(i).getContractId())
                    .insuranceId(contractList.get(i).getInsurance().getId())
                    .insuranceName(contractList.get(i).getInsurance().getName())
                    .insuranceType(type)
                    .message("보상 신청할 계약 ID를 입력해 주세요")
                    .build();

            getCompensationVoList.add(getCompensationVo);
        }

        return getCompensationVoList;
    }

    @Override
    public PostCompensationAmountVo compensationAmount(PostFireInsuranceDto postFireInsuranceDto ) {

        return PostCompensationAmountVo.of(postFireInsuranceDto);

    }

    @Override
    public PostCarDisclaimerVo carDisclaimer(PostCarDisclaimerDto postCarDisclaimerDto) {
        if (Indemnification.AccidentSubjectIndemnification.values()[postCarDisclaimerDto.getSubject()-1].isJudgment()
                && Indemnification.CarAccidentCauseIndemnification.values()[postCarDisclaimerDto.getCarCause()-1].isJudgment()) {
            return PostCarDisclaimerVo.builder()
                    .message("면부책에 통과 되셨습니다.")
                    .build();
        } else {
            //에러 처리로 변경해야됨.
            if (Indemnification.AccidentSubjectIndemnification.values()[postCarDisclaimerDto.getSubject()-1].isJudgment() == false) {
                return PostCarDisclaimerVo.builder()
                        .message(Indemnification.AccidentSubjectIndemnification.values()[postCarDisclaimerDto.getSubject()-1].getExplanation() + "로 인해 발생한 사고는 보험지급금 의무 면책 사유입니다.")
                        .build();
            } else {
                return PostCarDisclaimerVo.builder()
                        .message(Indemnification.CarAccidentCauseIndemnification.values()[postCarDisclaimerDto.getCarCause()-1].getExplanation() + "로 인해 발생한 사고는 보험지급금 의무 면책 사유입니다.")
                        .build();
            }
        }
    }
}
