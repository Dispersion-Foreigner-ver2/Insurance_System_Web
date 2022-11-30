package com.example.InsuranceSystem_Web.src.service.insurance;

import com.example.InsuranceSystem_Web.src.dao.insurance.InsuranceDao;
import com.example.InsuranceSystem_Web.src.dto.insurance.*;
import com.example.InsuranceSystem_Web.src.entity.insurance.*;
import com.example.InsuranceSystem_Web.src.exception.insuranceException.InsuranceEmptyException;
import com.example.InsuranceSystem_Web.src.vo.insurance.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@Slf4j
@RequiredArgsConstructor
public class InsuranceServiceImpl implements InsuranceService{

    private final InsuranceDao insuranceDao;

    @Override
    public PostInsuranceVo createInsuranceCar(PostCarInsuranceDto postCarRequest) {
            Insurance carInsurance = insuranceDao.save(postCarRequest.toEntity());
            return response(carInsurance, "자동차");
    }

    @Override
    public PostInsuranceVo createInsuranceFire(PostFireInsuranceDto postFireRequest) {
        Insurance fireInsurance = insuranceDao.save(postFireRequest.toEntity());
        return response(fireInsurance, "화재");
    }

    @Override
    public PostInsuranceVo createInsuranceSea(PostSeaInsuranceDto postSeaRequest) {
        Insurance seaInsurance = insuranceDao.save(postSeaRequest.toEntity());
        return response(seaInsurance, "해상");
    }


    public PostInsuranceVo response(Insurance insurance, String type){
        return PostInsuranceVo.builder()
                .message(type+" 보험 생성이 완료되었습니다. 보험 관리 화면에서 인가를 받아야 해당 보험을 이용할 수 있습니다. ")
                .name(insurance.getName())
                .insuranceId(insurance.getId())
                .build();
    }

    @Override
    public PostInsuranceVo setAuthorize(Long insuranceId) {
        Insurance insurance = insuranceDao.findById(insuranceId).get();
//                .orElseThrow(() -> new BaseException(EMPTY_INSURANCE));
        if(insurance != null){
            insurance.setAuthorization(true);
            insurance.setAuthorizationDate(LocalDateTime.now());
            insurance.setModifiedDate(LocalDateTime.now());
        }
        insuranceDao.save(insurance);

        return PostInsuranceVo.builder()
                .message("보험 설계의 인가가 완료되었습니다.")
                .name(insurance.getName())
                .insuranceId(insurance.getId())
                .build();
    }

    @Override
    public GetInsuranceCountVo readInsuranceCount() {
        List<Insurance> insuranceList = insuranceDao.findAll();
        System.out.println(insuranceList);

        int authCount = 0;
        int authNotCount = 0;

        for(int i=0; i<insuranceList.size(); i++){
            if(insuranceList.get(i).isAuthorization() == true) authCount++;
            else authNotCount++;
        }

        return GetInsuranceCountVo.builder()
                .insuranceSum(insuranceList.size())
                .authInsuranceSum(authCount)
                .authNotInsuranceSum(authNotCount)
                .build();
    }

    @Override
    public DeleteInsuranceVo deleteInsurance(Long insuranceId) {
        Optional<Insurance> insurance = insuranceDao.findById(insuranceId);
        if(insurance.isEmpty()){
            throw new InsuranceEmptyException();
        }
        insuranceDao.delete(insurance.get());
        return DeleteInsuranceVo.builder()
                .message("해당 보험을 성공적으로 삭제 완료하였습니다.")
                .build();
    }

    @Override
    public Object readInsurance() {
        List<Insurance> insuranceList = insuranceDao.findAll();
        if(insuranceList.isEmpty()){
            throw new InsuranceEmptyException();
        }else{
            List<GetInsuranceVo> insuranceVoList = new ArrayList<>();
            for(int i=0; i<insuranceList.size(); i++){
                GetInsuranceVo getInsuranceVo = setType(insuranceList.get(i));
                insuranceVoList.add(getInsuranceVo);
            }
            return insuranceVoList;
        }
    }

    @Override
    public Object readDetailInsurance(Long insuranceId) {
        Optional<Insurance> insurance = insuranceDao.findById(insuranceId);
        if(insurance.isEmpty()){
            throw new InsuranceEmptyException();
        }
        return setType(insurance.get());
    }

    public GetInsuranceVo setType(Insurance insurance){
        String type;
        if(insurance instanceof CarInsurance){
            type = "C";
        }else if(insurance instanceof FireInsurance){
            type = "F";
        }else {
            type = "S";
        }
        return GetInsuranceVo.builder()
                .insurance(insurance)
                .insuranceType(type)
                .build();
    }

}
