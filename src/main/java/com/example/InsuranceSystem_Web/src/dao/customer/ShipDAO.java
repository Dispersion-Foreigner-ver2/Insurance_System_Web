package com.example.InsuranceSystem_Web.src.dao.customer;

import com.example.InsuranceSystem_Web.src.entity.customer.Ship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface ShipDAO extends JpaRepository<Ship, Integer> {

}
