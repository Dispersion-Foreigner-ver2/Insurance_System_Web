package com.example.InsuranceSystem_Web.src.Controller.ContractService;

import com.example.InsuranceSystem_Web.src.Domain.Customer.Customer;

public interface CalculatePremium {

    public double calculatePremium(Customer customer, int premiumRate);
}
