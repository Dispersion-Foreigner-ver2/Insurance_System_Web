package com.example.InsuranceSystem_Web.src.service.contract;

import com.example.InsuranceSystem_Web.src.dto.contract.PostContractDto;
import com.example.InsuranceSystem_Web.src.dto.insurance.PostCarInsuranceDto;
import com.example.InsuranceSystem_Web.src.entity.customer.Customer;
import com.example.InsuranceSystem_Web.src.entity.insurance.Insurance;
import com.example.InsuranceSystem_Web.src.vo.contract.PostContractVo;
import com.example.InsuranceSystem_Web.src.vo.insurance.PostInsuranceVo;

import java.util.List;


public interface ContractService {
//    PostInsuranceVo createContract(PostContractDto postContractDto);
List<PostContractVo> contractManage( );

//PostContractVo contractSearch(Customer customer);

//    PostContractVo createContractManage();
}
