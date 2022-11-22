package com.example.InsuranceSystem_Web.src.dao.insurance;

import com.example.InsuranceSystem_Web.src.entity.Insurance.SeaInsurance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeaInsuraceDao extends JpaRepository<SeaInsurance, Integer> {
}
