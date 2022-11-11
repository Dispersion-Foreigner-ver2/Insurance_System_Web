package com.example.InsuranceSystem_Web.src.DAO.InsuranceDAO;

import com.example.InsuranceSystem_Web.src.Domain.Insurance.FireInsurance;

public interface FireInsuranceDAO {
  public boolean add(FireInsurance insurance);

  public boolean delete(int insuranceId);

  public FireInsurance get(int insuranceId);

  public boolean update(FireInsurance fireInsurance);

  public int getSize();
}
