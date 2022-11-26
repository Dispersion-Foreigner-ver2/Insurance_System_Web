package com.example.InsuranceSystem_Web.src.dao.insurance.delete;

import com.example.InsuranceSystem_Web.src.entity.insurance.SeaInsurance;

public interface SeaInsuranceDAO {
  public boolean add(SeaInsurance insurance);

  public boolean delete(int insuranceId);

  public SeaInsurance get(int insuranceId);

  public boolean update (SeaInsurance seaInsurance);

  public int getSize();
}
