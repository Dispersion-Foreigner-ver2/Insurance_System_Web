
package com.example.InsuranceSystem_Web.dao.CustomerDAO;

import com.example.InsuranceSystem_Web.domain.Customer.Ship;

import java.util.ArrayList;

public interface ShipDAO {
  boolean add(Ship ship);

  boolean delete(int id);

  Ship get(int id);

  boolean update(Ship ship);

  int getSize();

  public ArrayList<Ship> getShipList();
}
