package com.example.InsuranceSystem_Web.src.service.contract;

import com.example.InsuranceSystem_Web.src.dao.contract.ContractDao;
import com.example.InsuranceSystem_Web.src.dao.customer.CustomerDAO;
import com.example.InsuranceSystem_Web.src.dao.insurance.InsuranceDao;
import com.example.InsuranceSystem_Web.src.entity.contract.Contract;
import com.example.InsuranceSystem_Web.src.entity.customer.Customer;
import com.example.InsuranceSystem_Web.src.entity.insurance.CarInsurance;
import com.example.InsuranceSystem_Web.src.entity.insurance.FireInsurance;
import com.example.InsuranceSystem_Web.src.entity.insurance.Insurance;
import com.example.InsuranceSystem_Web.src.vo.contract.PostContractManageVo;
import com.example.InsuranceSystem_Web.src.vo.contract.PostContractSearchVo;
import com.example.InsuranceSystem_Web.src.vo.contract.PostContractTerminateVo;
import com.example.InsuranceSystem_Web.src.vo.contract.PostContractVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class ContractServiceImpl implements ContractService{

    private final InsuranceDao insuranceDao;

    private final CustomerDAO customerDAO;
    private final ContractDao contractDao;

    @Override
    public List<PostContractManageVo> contractManage( ) {
        List<Insurance> insuranceList = insuranceDao.findAll();
        List<PostContractManageVo> postContractManageVoList = new ArrayList<>();

        for (int i = 0; i < insuranceList.size(); i++) {
            List<Contract> contractList = contractDao.findByInsuranceId(insuranceList.get(i).getId());
            String type;
            if (insuranceList.get(i) instanceof CarInsurance) {
                type = "C";
            } else if (insuranceList.get(i) instanceof FireInsurance) {
                type = "F";
            } else {
                type = "S";
            }
            PostContractManageVo postContractManageVo = PostContractManageVo.builder()
                    .insuranceId(insuranceList.get(i).getId())
                    .InsuranceName(insuranceList.get(i).getName())
                    .insuranceType(type)
                    .insuranceResignCount(contractList.size())
                    .build();

            postContractManageVoList.add(postContractManageVo);
        }

        return postContractManageVoList;
    }

    @Override
    public PostContractSearchVo contractSearch(Long customerId) {
        Customer customer= customerDAO.findById(customerId).get();
        Contract contract=contractDao.findByCustomer(customer);

        if(customer!=contract.getCustomer()){

        }

        return PostContractSearchVo.builder()
                .contractId(contract.getContractId())
                .customerId(customer.getId())
                .customerName(customer.getName())
                .customerInsuranceId(contract.getInsurance().getId())
                .customerInsuranceName(contract.getInsurance().getName())
                .build();
    }

    @Override
    public PostContractTerminateVo contractTerminate(Long contractId) {
        Contract contract=contractDao.findById(contractId).get();

        if(contract!=null){
            contract.setContractDate(Date.from(Instant.now()));

        }
        contractDao.delete(contract);

        return PostContractTerminateVo.builder()
                .message("보험 계약 해지가 완료되었습니다.")
//                .contractId(contract.getContractId())
                .build();
    }

    @Override
    public Object contractConclusion() {
        return null;
    }

    @Override
    public PostContractVo contract(Long insuranceId) {
        Optional<Insurance> insurance=insuranceDao.findById(insuranceId);

        insuranceDao.save(insurance.get());
        return PostContractVo.builder()
                .message("")
                .build();
    }
}




