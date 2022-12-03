package com.example.InsuranceSystem_Web.src.service.contract;

import com.example.InsuranceSystem_Web.src.dao.contract.ContractDao;
import com.example.InsuranceSystem_Web.src.dao.customer.CustomerDAO;
import com.example.InsuranceSystem_Web.src.dao.insurance.InsuranceDao;
import com.example.InsuranceSystem_Web.src.dto.contract.PostContractDto;
import com.example.InsuranceSystem_Web.src.entity.contract.Contract;
import com.example.InsuranceSystem_Web.src.entity.customer.Customer;
import com.example.InsuranceSystem_Web.src.entity.insurance.CarInsurance;
import com.example.InsuranceSystem_Web.src.entity.insurance.FireInsurance;
import com.example.InsuranceSystem_Web.src.entity.insurance.Insurance;
import com.example.InsuranceSystem_Web.src.vo.contract.PostContractVo;
import com.example.InsuranceSystem_Web.src.vo.insurance.PostInsuranceVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ContractServiceImpl implements ContractService{

    private final InsuranceDao insuranceDao;

//    private final CustomerDAO customerDAO;
    private final ContractDao contractDao;

//    @Override
//    public PostInsuranceVo createContract(PostContractDto postContractDto) {
//        return null;
//    }

    @Override
    public List<PostContractVo> contractManage( ) {
        List<Insurance> insuranceList=insuranceDao.findAll();
       List<PostContractVo> postContractVoList=new ArrayList<>();

        for(int i=0; i<insuranceList.size();i++){
            List<Contract> contractList=contractDao.findByInsuranceId(insuranceList.get(i).getId());
            String type;
            if(insuranceList.get(i) instanceof CarInsurance){
                type = "C";
            }else if(insuranceList.get(i) instanceof FireInsurance){
                type = "F";
            }else {
                type = "S";
            }
            PostContractVo postContractVo=PostContractVo.builder()
                    .insuranceId(
                    insuranceList.get(i).getId())
                    .InsuranceName(insuranceList.get(i).getName())
                    .insuranceType(type)
                    .insuranceResignCount(contractList.size())
                    .build();

            postContractVoList.add(postContractVo);
        }

        return postContractVoList;
    }

//    @Override
//    public PostContractVo contractSearch(Customer customerId) {
//        List<Customer> customerList=customerDAO.findAll();
//
//
//
//        return
//    }

//    @Override
//    public PostContractVo createContractManage() {
//        List<Contract> contractList=contractDao.findAll();
//        System.out.println(contractList);
//
//        return PostContractVo.builder()
//                .insuranceId(contractList.)
//

    }



