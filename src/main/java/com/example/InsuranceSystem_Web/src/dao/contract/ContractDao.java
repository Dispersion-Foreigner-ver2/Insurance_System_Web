package com.example.InsuranceSystem_Web.src.dao.contract;

import com.example.InsuranceSystem_Web.src.entity.contract.Contract;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractDao extends JpaRepository<Contract, Long> {
}
