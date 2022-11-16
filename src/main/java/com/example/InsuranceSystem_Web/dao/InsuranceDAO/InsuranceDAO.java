package com.example.InsuranceSystem_Web.dao.InsuranceDAO;

import com.example.InsuranceSystem_Web.domain.Insurance.Insurance;

import java.util.ArrayList;


public interface InsuranceDAO {

	public boolean add(Insurance insurance);

	public boolean delete(int insuranceId);

	public boolean update(Insurance insurance);

	public Insurance get(int insuranceId);

	public int getSize();

	public ArrayList<Insurance> getInsuranceList();
}
