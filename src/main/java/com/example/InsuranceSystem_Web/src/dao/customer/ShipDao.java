package com.example.InsuranceSystem_Web.src.dao.customer;

import com.example.InsuranceSystem_Web.src.entity.customer.Ship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface ShipDao extends JpaRepository<Ship, Integer> {

}
