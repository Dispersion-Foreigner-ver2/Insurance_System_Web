package com.example.InsuranceSystem_Web.src.service.contract;

import com.example.InsuranceSystem_Web.src.dto.req.contract.PostContractReq;
import com.example.InsuranceSystem_Web.src.dto.res.contract.*;
import com.example.InsuranceSystem_Web.src.entity.contract.Contract;

import java.util.List;


public interface ContractService {

    List<PostContractManageRes> contractManage();
    List<Contract> getContractList();

    List<GetContractSearchRes> contractSearchAll(Long customerId);
    GetContractSearchRes contractSearch(Long contractId);

    DeleteContractTerminateRes contractTerminate(Long contractId);
    PostContractConclusionRes contractConclusion(PostContractReq insuranceId);

    List<GetUnderWriteRes> getUnderWriteAll();
    List<GetUnderWriteRes> getUnderWrites(Long customerId);
    GetUnderWriteRes getUnderWrite(Long contractId);

    UpdateUnderWriteRes updateUnderWrite(Long contractId);

}
