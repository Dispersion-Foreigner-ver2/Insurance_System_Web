package com.example.InsuranceSystem_Web.Controller.ContractService;

import com.example.InsuranceSystem_Web.Domain.Customer.Customer;

public interface CalculatePremium {

    public double calculatePremium(Customer customer, int premiumRate);
}
