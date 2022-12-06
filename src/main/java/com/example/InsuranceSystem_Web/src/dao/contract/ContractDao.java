package com.example.InsuranceSystem_Web.src.dao.contract;

import com.example.InsuranceSystem_Web.src.entity.contract.Contract;
import com.example.InsuranceSystem_Web.src.entity.customer.Customer;
import com.example.InsuranceSystem_Web.src.entity.insurance.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContractDao extends JpaRepository<Contract, Long> {
    List<Contract> findByInsuranceId(Long id);

    Contract findByCustomer(Customer customer);

    Contract findByInsuranceId(Insurance insurance);
}
