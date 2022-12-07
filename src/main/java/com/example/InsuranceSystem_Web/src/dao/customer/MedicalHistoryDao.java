package com.example.InsuranceSystem_Web.src.dao.customer;

import com.example.InsuranceSystem_Web.src.entity.customer.Customer;
import com.example.InsuranceSystem_Web.src.entity.customer.MedicalHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

public interface MedicalHistoryDao extends JpaRepository<MedicalHistory, Integer> {

    MedicalHistory findByCustomer(Customer customer);
}
