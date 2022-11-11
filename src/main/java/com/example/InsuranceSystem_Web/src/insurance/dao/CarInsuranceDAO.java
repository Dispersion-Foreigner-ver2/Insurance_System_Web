package com.example.InsuranceSystem_Web.src.insurance.dao;

import com.example.InsuranceSystem_Web.src.insurance.entity.CarInsurance;

public interface CarInsuranceDAO {

  public boolean add(CarInsurance carInsurance);

  public boolean delete(int insuranceId);

  public boolean update(CarInsurance insuranceId);

  public CarInsurance get(int insuranceId);

  public int getSize();
}
