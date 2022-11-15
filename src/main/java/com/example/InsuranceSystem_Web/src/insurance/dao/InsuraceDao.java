package com.example.InsuranceSystem_Web.src.insurance.dao;

import com.example.InsuranceSystem_Web.src.insurance.entity.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsuraceDao extends JpaRepository<Insurance, Integer> {
}
