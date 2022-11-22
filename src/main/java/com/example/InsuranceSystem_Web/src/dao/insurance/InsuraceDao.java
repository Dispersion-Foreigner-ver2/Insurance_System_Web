package com.example.InsuranceSystem_Web.src.dao.insurance;

import com.example.InsuranceSystem_Web.src.entity.Insurance.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsuraceDao extends JpaRepository<Insurance, Integer> {
}
