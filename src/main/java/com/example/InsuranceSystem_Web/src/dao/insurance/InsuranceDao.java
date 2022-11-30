package com.example.InsuranceSystem_Web.src.dao.insurance;

import com.example.InsuranceSystem_Web.src.entity.insurance.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface InsuranceDao extends JpaRepository<Insurance, Long> {
}
