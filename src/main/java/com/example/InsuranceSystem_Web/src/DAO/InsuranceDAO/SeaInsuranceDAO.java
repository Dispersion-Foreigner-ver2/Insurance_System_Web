package com.example.InsuranceSystem_Web.src.DAO.InsuranceDAO;

import com.example.InsuranceSystem_Web.src.Domain.Insurance.SeaInsurance;

public interface SeaInsuranceDAO {
  public boolean add(SeaInsurance insurance);

  public boolean delete(int insuranceId);

  public SeaInsurance get(int insuranceId);

  public boolean update (SeaInsurance seaInsurance);

  public int getSize();
}
