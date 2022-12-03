package com.example.InsuranceSystem_Web.src.service.contract;

import com.example.InsuranceSystem_Web.src.vo.contract.PostContractManageVo;

import java.util.List;


public interface ContractService {

List<PostContractManageVo> contractManage( );

    Object contractSearch(Long customerId);
}
