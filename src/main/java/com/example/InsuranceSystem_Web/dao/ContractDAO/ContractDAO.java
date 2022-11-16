package com.example.InsuranceSystem_Web.dao.ContractDAO;

import com.example.InsuranceSystem_Web.domain.Contract.Contract;

import java.util.ArrayList;

public interface ContractDAO {

	public boolean add(Contract contract);

	public boolean delete(int contractId);

	public Contract get(int contractId);

	public boolean update( Contract contract);

	public int getSize();

	public ArrayList<Contract> getContractList();
}
