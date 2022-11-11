package com.example.InsuranceSystem_Web.DAO.CustomerDAO;

import com.example.InsuranceSystem_Web.Domain.Customer.MedicalHistory;

import java.util.ArrayList;

public interface MedicalHistoryDAO {
  boolean add(MedicalHistory medicalHistory);

  boolean delete(int customerId);

  MedicalHistory get(int customerId);

  boolean update(MedicalHistory medicalHistory);

  int getSize();

  public ArrayList<MedicalHistory> getMedicalHistoryList();

}
