package com.example.InsuranceSystem_Web.src.service.contract;

import com.example.InsuranceSystem_Web.src.dao.contract.ContractDao;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ContractServiceImpl implements ContractService{

    private final ContractDao contractDao;

    @Override
    public Object createContract() {
        return null;
    }
}
