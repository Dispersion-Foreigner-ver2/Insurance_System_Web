package com.example.InsuranceSystem_Web.src.service.insurance;

import com.example.InsuranceSystem_Web.src.dao.insurance.InsuranceDao;
import com.example.InsuranceSystem_Web.src.dto.req.insurance.PostCarInsuranceReq;
import com.example.InsuranceSystem_Web.src.dto.req.insurance.PostFireInsuranceReq;
import com.example.InsuranceSystem_Web.src.dto.req.insurance.PostSeaInsuranceReq;
import com.example.InsuranceSystem_Web.src.dto.res.insurance.DeleteInsuranceRes;
import com.example.InsuranceSystem_Web.src.dto.res.insurance.GetInsuranceCountRes;
import com.example.InsuranceSystem_Web.src.dto.res.insurance.GetInsuranceRes;
import com.example.InsuranceSystem_Web.src.dto.res.insurance.PostInsuranceRes;
import com.example.InsuranceSystem_Web.src.entity.insurance.*;
import com.example.InsuranceSystem_Web.src.exception.insurance.EmptyInsuranceException;
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
public class InsuranceServiceImpl implements InsuranceService {

    private final InsuranceDao insuranceDao;

    @Override
    public PostInsuranceRes createInsuranceCar(PostCarInsuranceReq postCarRequest) {
        Insurance carInsurance = insuranceDao.save(postCarRequest.toEntity());
        return response(carInsurance, "자동차");
    }

    @Override
    public PostInsuranceRes createInsuranceFire(PostFireInsuranceReq postFireRequest) {
        Insurance fireInsurance = insuranceDao.save(postFireRequest.toEntity());
        return response(fireInsurance, "화재");
    }

    @Override
    public PostInsuranceRes createInsuranceSea(PostSeaInsuranceReq postSeaRequest) {
        Insurance seaInsurance = insuranceDao.save(postSeaRequest.toEntity());
        return response(seaInsurance, "해상");
    }

    //객체를 만들어서 컨트롤러로 보낸 것
    public PostInsuranceRes response(Insurance insurance, String type) {
        return PostInsuranceRes.builder()
                .message(type + " 보험 생성이 완료되었습니다. 보험 관리 화면에서 인가를 받아야 해당 보험을 이용할 수 있습니다. ")
                .name(insurance.getName())
                .insuranceId(insurance.getId())
                .build();
    }

    @Override
    public PostInsuranceRes setAuthorize(Long insuranceId) {
        Insurance insurance = insuranceDao.findById(insuranceId).get();
        if (insurance == null) {
            throw new EmptyInsuranceException();
        }
        insurance.setAuthorization(true);
        insurance.setAuthorizationDate(LocalDateTime.now());
        insurance.setModifiedDate(LocalDateTime.now());

        insuranceDao.save(insurance);

        return PostInsuranceRes.builder()
                .message("보험 설계의 인가가 완료되었습니다.")
                .name(insurance.getName())
                .insuranceId(insurance.getId())
                .build();
    }

    @Override
    public GetInsuranceCountRes readInsuranceCount() {
        List<Insurance> insuranceList = insuranceDao.findAll();
        System.out.println(insuranceList);

        int authCount = 0;
        int authNotCount = 0;

        if(insuranceList.size() !=0){
            for (int i = 0; i < insuranceList.size(); i++) {
                if (insuranceList.get(i).isAuthorization() == true) authCount++;
                else authNotCount++;
            }
        }

        return GetInsuranceCountRes.builder()
                .insuranceSum(insuranceList.size())
                .authInsuranceSum(authCount)
                .authNotInsuranceSum(authNotCount)
                .build();
    }

    @Override
    public DeleteInsuranceRes deleteInsurance(Long insuranceId) {
        Optional<Insurance> insurance = insuranceDao.findById(insuranceId);
        if (insurance.isEmpty()) {
            throw new EmptyInsuranceException();
        }
        insuranceDao.delete(insurance.get());
        return DeleteInsuranceRes.builder()
                .message("해당 보험을 성공적으로 삭제 완료하였습니다.")
                .build();
    }

    @Override
    public Object readInsurance() {
        List<Insurance> insuranceList = insuranceDao.findAll();
        if (insuranceList.isEmpty()) {
            throw new EmptyInsuranceException();
        }
        List<GetInsuranceRes> insuranceVoList = new ArrayList<>();
        for (int i = 0; i < insuranceList.size(); i++) {
            GetInsuranceRes getInsuranceVo = setType(insuranceList.get(i));
            insuranceVoList.add(getInsuranceVo);
        }
        return insuranceVoList;

    }

    @Override
    public Object readDetailInsurance(Long insuranceId) {
        Optional<Insurance> insurance = insuranceDao.findById(insuranceId);
        if (insurance.isEmpty()) {
            throw new EmptyInsuranceException();
        }
        return setType(insurance.get());
    }

    public GetInsuranceRes setType(Insurance insurance) {
        String type;
        if (insurance instanceof CarInsurance) {
            type = "C";
        } else if (insurance instanceof FireInsurance) {
            type = "F";
        } else {
            type = "S";
        }
        return GetInsuranceRes.builder()
                .insurance(insurance)
                .insuranceType(type)
                .build();
    }

}
