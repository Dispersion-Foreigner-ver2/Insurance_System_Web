package com.example.InsuranceSystem_Web.src.DAO.CustomerDAO;

import com.example.InsuranceSystem_Web.src.Domain.Customer.Car;

import java.util.ArrayList;

public interface CarDAO {
  boolean add(Car car);

  boolean delete(int id);

  Car get(int id);

  boolean update(Car car);

  int getSize();

  public ArrayList<Car> getCarList();
}
