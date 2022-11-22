package com.example.InsuranceSystem_Web.src.dao.contract;

import com.example.InsuranceSystem_Web.src.entity.contract.Contract;

import java.util.ArrayList;

public interface ContractDAO {

	public boolean add(Contract contract);

	public boolean delete(int contractId);

	public Contract get(int contractId);

	public boolean update( Contract contract);

	public int getSize();

	public ArrayList<Contract> getContractList();
}
