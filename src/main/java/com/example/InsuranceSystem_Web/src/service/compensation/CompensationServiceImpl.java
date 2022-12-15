package com.example.InsuranceSystem_Web.src.service.compensation;

import com.example.InsuranceSystem_Web.src.dao.contract.ContractDao;
import com.example.InsuranceSystem_Web.src.dto.req.compensation.PostCarDisclaimerReq;
import com.example.InsuranceSystem_Web.src.dto.req.insurance.PostFireInsuranceReq;
import com.example.InsuranceSystem_Web.src.entity.contract.Contract;
import com.example.InsuranceSystem_Web.src.entity.insurance.CarInsurance;
import com.example.InsuranceSystem_Web.src.entity.insurance.FireInsurance;
import com.example.InsuranceSystem_Web.src.dto.res.compensation.GetCompensationRes;
import com.example.InsuranceSystem_Web.src.dto.res.compensation.PostCarDisclaimerRes;
import com.example.InsuranceSystem_Web.src.dto.res.compensation.PostCompensationAmountRes;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class CompensationServiceImpl implements CompensationService {

    private final ContractDao contractDao;


    @Override
    public List<GetCompensationRes> compensation(Long customerId) {
        List<Contract> contractList=contractDao.findByCustomerId(customerId);
        List<GetCompensationRes> getCompensationVoList= new ArrayList<>();

        for (int i = 0; i < contractList.size(); i++) {

            String type;
            if (contractList.get(i).getInsurance() instanceof CarInsurance) {
                type = "C";
            } else if (contractList.get(i).getInsurance() instanceof FireInsurance) {
                type = "F";
            } else {
                type = "S";
            }
            GetCompensationRes getCompensationVo = GetCompensationRes.builder()
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
    public PostCompensationAmountRes compensationAmount(PostFireInsuranceReq postFireInsuranceDto ) {

        return PostCompensationAmountRes.of(postFireInsuranceDto);

    }

    @Override
    public PostCarDisclaimerRes carDisclaimer(PostCarDisclaimerReq postCarDisclaimerDto) {
        if (Indemnification.AccidentSubjectIndemnification.values()[postCarDisclaimerDto.getSubject()-1].isJudgment()
                && Indemnification.CarAccidentCauseIndemnification.values()[postCarDisclaimerDto.getCarCause()-1].isJudgment()) {
            return PostCarDisclaimerRes.builder()
                    .message("면부책에 통과 되셨습니다.")
                    .build();
        } else {
            //에러 처리로 변경해야됨.
            if (Indemnification.AccidentSubjectIndemnification.values()[postCarDisclaimerDto.getSubject()-1].isJudgment() == false) {
                return PostCarDisclaimerRes.builder()
                        .message(Indemnification.AccidentSubjectIndemnification.values()[postCarDisclaimerDto.getSubject()-1].getExplanation() + "로 인해 발생한 사고는 보험지급금 의무 면책 사유입니다.")
                        .build();
            } else {
                return PostCarDisclaimerRes.builder()
                        .message(Indemnification.CarAccidentCauseIndemnification.values()[postCarDisclaimerDto.getCarCause()-1].getExplanation() + "로 인해 발생한 사고는 보험지급금 의무 면책 사유입니다.")
                        .build();
            }
        }
    }
}
