
package com.example.InsuranceSystem_Web.dao.CustomerDAO;

import com.example.InsuranceSystem_Web.domain.Customer.House;

import java.util.ArrayList;

public interface HouseDAO {
  boolean add(House house);

  boolean delete(int id);

  House get(int id);

  boolean update(House house);

  int getSize();

  public ArrayList<House> getHouseList();
}
