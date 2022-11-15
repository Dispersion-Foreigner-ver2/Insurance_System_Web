package com.example.InsuranceSystem_Web.src.insurance.service;

import com.example.InsuranceSystem_Web.src.insurance.dao.*;
import com.example.InsuranceSystem_Web.src.insurance.dto.*;
import com.example.InsuranceSystem_Web.src.insurance.entity.*;
import com.example.InsuranceSystem_Web.src.insurance.vo.PostInsuranceRes;
import io.swagger.models.auth.In;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class InsuranceServiceImpl implements InsuranceService{

    private final InsuraceDao insuraceDao;
    private final CarInsuraceDao carInsuraceDao;
    private final FireInsuraceDao fireInsuraceDao;
    private final SeaInsuraceDao seaInsuraceDao;

    @Override
    public PostInsuranceRes createInsuranceCar(PostCarReq postCarRequest) {
        Insurance insurance = insuraceDao.save(postCarRequest.toInsuranceEntity(Insurance.Type.Car));
        CarInsurance carInsurance = carInsuraceDao.save(postCarRequest.toEntity(insurance));
        return response(insurance, "자동차");
    }

    @Override
    public PostInsuranceRes createInsuranceFire(PostFireReq postFireRequest) {
        Insurance insurance = insuraceDao.save(postFireRequest.toInsuranceEntity(Insurance.Type.Fire));
        FireInsurance fireInsurance = fireInsuraceDao.save(postFireRequest.toEntity(insurance));
        return response(insurance, "화재");
    }

    @Override
    public PostInsuranceRes createInsuranceSea(PostSeaReq postSeaRequest) {
        Insurance insurance = insuraceDao.save(postSeaRequest.toInsuranceEntity(Insurance.Type.Sea));
        SeaInsurance seaInsurance = seaInsuraceDao.save(postSeaRequest.toEntity(insurance));
        return response(insurance, "해상");
    }

    public PostInsuranceRes response(Insurance insurance, String type){
        return PostInsuranceRes.builder()
                .message(type+" 보험 설계가 완료되었습니다.")
                .name(insurance.getName())
                .insuranceId(insurance.getInsuranceId())
                .type(insurance.getType())
                .build();
    }


//    public ArrayList<Insurance> getInsuranceList() {
//        return this.insuranceDAO.getInsuranceList();
//    }
//
//    public Insurance getInsurance(int insuranceId) {
//        Insurance insurance = insuranceDAO.get(insuranceId);
//        if (insurance != null) {
//            return insurance;
//        }
//        return null;
//    }
//
//    public String getInsuranceName(int insuranceId) {
//        for (Insurance insurance : this.insuranceDAO.getInsuranceList()) {
//            if (insurance.getId() == insuranceId) {
//                return insurance.getName();
//            }
//        }
//
//        return null;
//    }
//
//    public Insurance design(int type, String name, String explanation, int premium, int surroundingDamageBasicMoney, int humanDamageBasicMoney, int buildingDamageBasicMoney
//            , int carDamageBasicMoney, int generalDamageBasicMoney, int revenueDamageBasicMoney){
//        Insurance insurance = null;
//        if (type == 1) {
//            insurance = new FireInsurance();
//        } else if (type == 2) {
//            insurance = new CarInsurance();
//        } else if (type == 3) {
//            insurance = new SeaInsurance();
//
//        } else {
//            return null;
//        }
//
//        insurance.setId(setInsuranceId());
//        insurance.setType(Insurance.Type.values()[type - 1]);
//        insurance.setAuthorization(false);
//        insurance.setCreatedDate(Timestamp.valueOf(LocalDateTime.now()));
//        insurance.setModifiedDate(Timestamp.valueOf(LocalDateTime.now()));
//        insurance.setName(name);
//        insurance.setExplanation(explanation);
//        insurance.setPremium(premium);
//
//
//        if (insurance instanceof FireInsurance) {
//            ((FireInsurance) insurance).setSurroundingDamageBasicMoney(surroundingDamageBasicMoney);
//            ((FireInsurance) insurance).setHumanDamageBasicMoney(humanDamageBasicMoney);
//            ((FireInsurance) insurance).setBuildingDamageBasicMoney(buildingDamageBasicMoney);
//        }else if (insurance instanceof CarInsurance) {
//            ((CarInsurance) insurance).setCarDamageBasicMoney(carDamageBasicMoney);
//            ((CarInsurance) insurance).setHumanDamageBasicMoney(humanDamageBasicMoney);
//        }else if (insurance instanceof SeaInsurance) {
//            ((SeaInsurance) insurance).setGeneralDamageBasicMoney(generalDamageBasicMoney);
//            ((SeaInsurance) insurance).setRevenueDamageBasicMoney(revenueDamageBasicMoney);
//        }
//
//        insuranceDAO.add(insurance);
//
//
//        return insurance;
//    }
//
//    public int setInsuranceId() {
//        int insuranceId = 1;
//        while (true) {
//            if (insuranceDAO.get(insuranceId) == null) {
//                return insuranceId;
//            } else {
//                insuranceId++;
//            }
//        }
//    }
//
//    public boolean authorize(int insuranceId) {
//        Insurance insurance = this.insuranceDAO.get(insuranceId);
//        if (insurance == null) {
//            return false;
//        }
//        insurance.setAuthorization(true);
//        insurance.setAuthorizationDate(Timestamp.valueOf(LocalDateTime.now()));
//        return insuranceDAO.update(insurance);
//    }
//
//    public boolean deleteInsurance(int insuranceId) {
//        return insuranceDAO.delete(insuranceId);
//    }
//
//
//
//    public int computeAuthorizeCount() {
//        int count = 0;
//        if (insuranceDAO instanceof DBInsuranceDAO) {
//            for (Insurance insurance : ((DBInsuranceDAO) insuranceDAO).getInsuranceList()) {
//                if (insurance.isAuthorization()) {
//                    count++;
//                }
//            }
//        }
//        return count;
//    }
//
//    public int computeNotAuthorizeCount() {
//        int count = 0;
//        if (insuranceDAO instanceof DBInsuranceDAO) {
//            for (Insurance insurance : ((DBInsuranceDAO) insuranceDAO).getInsuranceList()) {
//                if (!insurance.isAuthorization()) {
//                    count++;
//                }
//            }
//        }
//        return count;
//    }
//
//
//    public int computeTotalSize() {
//        return this.insuranceDAO.getSize();
//    }

}
