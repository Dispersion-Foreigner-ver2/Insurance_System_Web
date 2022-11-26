package com.example.InsuranceSystem_Web.src.dao.insurance.delete;

import com.example.InsuranceSystem_Web.src.entity.insurance.CarInsurance;

public interface CarInsuranceDAO  {

  public boolean add(CarInsurance carInsurance);

  public boolean delete(int insuranceId);

  public boolean update(CarInsurance insuranceId);

  public CarInsurance get(int insuranceId);

  public int getSize();
}
