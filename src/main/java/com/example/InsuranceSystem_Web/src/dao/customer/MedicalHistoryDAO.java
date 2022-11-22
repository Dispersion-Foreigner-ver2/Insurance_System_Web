package com.example.InsuranceSystem_Web.src.dao.customer;

import com.example.InsuranceSystem_Web.src.entity.customer.MedicalHistory;

import java.util.ArrayList;

public interface MedicalHistoryDAO {
  boolean add(MedicalHistory medicalHistory);

  boolean delete(int customerId);

  MedicalHistory get(int customerId);

  boolean update(MedicalHistory medicalHistory);

  int getSize();

  public ArrayList<MedicalHistory> getMedicalHistoryList();

}
