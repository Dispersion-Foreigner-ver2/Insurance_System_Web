package com.example.InsuranceSystem_Web.src.dao.insurance;

import com.example.InsuranceSystem_Web.src.entity.insurance.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsuranceDao extends JpaRepository<Insurance, Long> {
}
