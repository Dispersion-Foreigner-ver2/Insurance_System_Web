package com.example.InsuranceSystem_Web.src.dao.customer;
import com.example.InsuranceSystem_Web.src.entity.customer.Customer;

import java.util.ArrayList;

public interface CustomerDAO {
	boolean add(Customer customer);

	boolean delete(int customerId);

	Customer get(int customerId);

	boolean update(Customer customer);

	int getSize();

	public ArrayList<Customer> getCustomerList();
}
