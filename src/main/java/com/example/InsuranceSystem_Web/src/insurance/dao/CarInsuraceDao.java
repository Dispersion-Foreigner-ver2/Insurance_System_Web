package com.example.InsuranceSystem_Web.src.insurance.dao;

import com.example.InsuranceSystem_Web.src.insurance.entity.CarInsurance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarInsuraceDao extends JpaRepository<CarInsurance, Integer> {
}
