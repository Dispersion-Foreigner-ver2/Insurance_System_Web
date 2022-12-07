package com.example.InsuranceSystem_Web.src.service.contract;

import com.example.InsuranceSystem_Web.src.dto.contract.*;
import com.example.InsuranceSystem_Web.src.vo.contract.*;

import java.util.List;


public interface ContractService {

    List<PostContractManageVo> contractManage();
    Object getContractList();

    Object contractSearchAll(Long customerId);
    GetContractSearchVo contractSearch(Long contractId);

    DeleteContractTerminateVo contractTerminate(Long contractId);
    PostContractConclusionVo contractConclusion(PostContractDto insuranceId);

    List<GetUnderWriteVo> getUnderWriteAll();
    List<GetUnderWriteVo> getUnderWrites(Long customerId);
    GetUnderWriteVo getUnderWrite(Long contractId);

    UpdateUnderWriteVo updateUnderWrite(Long contractId);

}
