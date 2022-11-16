package com.example.InsuranceSystem_Web.dao.InsuranceDAO;

import com.example.InsuranceSystem_Web.domain.Insurance.SeaInsurance;

public interface SeaInsuranceDAO {
  public boolean add(SeaInsurance insurance);

  public boolean delete(int insuranceId);

  public SeaInsurance get(int insuranceId);

  public boolean update (SeaInsurance seaInsurance);

  public int getSize();
}
