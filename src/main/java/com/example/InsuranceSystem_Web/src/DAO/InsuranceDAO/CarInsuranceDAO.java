package com.example.InsuranceSystem_Web.src.DAO.InsuranceDAO;

import com.example.InsuranceSystem_Web.src.Domain.Insurance.CarInsurance;

public interface CarInsuranceDAO {

  public boolean add(CarInsurance carInsurance);

  public boolean delete(int insuranceId);

  public boolean update(CarInsurance insuranceId);

  public CarInsurance get(int insuranceId);

  public int getSize();
}
