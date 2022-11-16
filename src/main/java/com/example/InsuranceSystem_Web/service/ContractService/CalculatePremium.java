package com.example.InsuranceSystem_Web.service.ContractService;

import com.example.InsuranceSystem_Web.domain.Customer.Customer;

public interface CalculatePremium {

    public double calculatePremium(Customer customer, int premiumRate);
}
