package com.example.InsuranceSystem_Web.src.service.contract;

import com.example.InsuranceSystem_Web.src.vo.contract.*;

import java.util.List;


public interface ContractService {

List<PostContractManageVo> contractManage( );

    PostContractSearchVo contractSearch(Long customerId);

    PostContractTerminateVo contractTerminate(Long contractId);

    PostContractConclusionVo contractConclusion( Long insuranceId  );

//    PostContractVo contract(Long insuranceId);
}
