package com.example.InsuranceSystem_Web.src.insurance.dao.delete;

import com.example.InsuranceSystem_Web.src.insurance.entity.CarInsurance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface CarInsuranceDAO  {

  public boolean add(CarInsurance carInsurance);

  public boolean delete(int insuranceId);

  public boolean update(CarInsurance insuranceId);

  public CarInsurance get(int insuranceId);

  public int getSize();
}
