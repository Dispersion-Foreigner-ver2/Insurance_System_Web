package com.example.InsuranceSystem_Web.src.service.contract;

import com.example.InsuranceSystem_Web.src.vo.contract.PostContractManageVo;
import com.example.InsuranceSystem_Web.src.vo.contract.PostContractSearchVo;
import com.example.InsuranceSystem_Web.src.vo.contract.PostContractTerminateVo;

import java.util.List;


public interface ContractService {

List<PostContractManageVo> contractManage( );

    PostContractSearchVo contractSearch(Long customerId);

    PostContractTerminateVo contractTerminate(Long contractId);

    Object contractConclusion();

    Object contract(Long insuranceId);
}
