package com.example.InsuranceSystem_Web.src.insurance.dao;

import com.example.InsuranceSystem_Web.src.insurance.entity.FireInsurance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FireInsuraceDao extends JpaRepository<FireInsurance, Integer> {
}
