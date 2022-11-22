package com.example.InsuranceSystem_Web.src.dao.insurance;

import com.example.InsuranceSystem_Web.src.entity.Insurance.FireInsurance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FireInsuraceDao extends JpaRepository<FireInsurance, Integer> {
}
