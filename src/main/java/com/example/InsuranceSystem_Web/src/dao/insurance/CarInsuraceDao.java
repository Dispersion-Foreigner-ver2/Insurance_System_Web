package com.example.InsuranceSystem_Web.src.dao.insurance;

import com.example.InsuranceSystem_Web.src.entity.Insurance.CarInsurance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarInsuraceDao extends JpaRepository<CarInsurance, Integer> {
}
