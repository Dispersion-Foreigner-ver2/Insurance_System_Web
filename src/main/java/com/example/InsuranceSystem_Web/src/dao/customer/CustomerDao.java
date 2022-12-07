package com.example.InsuranceSystem_Web.src.dao.customer;
import com.example.InsuranceSystem_Web.src.entity.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface CustomerDao extends JpaRepository<Customer, Long> {

}
