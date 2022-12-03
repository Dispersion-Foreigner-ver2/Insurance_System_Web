package com.example.InsuranceSystem_Web.src.dao.staff;

import com.example.InsuranceSystem_Web.src.entity.staff.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;


public interface StaffDAO extends JpaRepository<Staff, Long> {

}
