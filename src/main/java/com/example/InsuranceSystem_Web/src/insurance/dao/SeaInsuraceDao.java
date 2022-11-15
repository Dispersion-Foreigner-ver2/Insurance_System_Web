package com.example.InsuranceSystem_Web.src.insurance.dao;

import com.example.InsuranceSystem_Web.src.insurance.entity.FireInsurance;
import com.example.InsuranceSystem_Web.src.insurance.entity.SeaInsurance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeaInsuraceDao extends JpaRepository<SeaInsurance, Integer> {
}
