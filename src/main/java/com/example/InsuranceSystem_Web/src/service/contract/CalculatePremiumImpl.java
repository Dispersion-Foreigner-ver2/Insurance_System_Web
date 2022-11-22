package com.example.InsuranceSystem_Web.src.service.contract;

import com.example.InsuranceSystem_Web.src.entity.customer.Customer;

public class CalculatePremiumImpl implements CalculatePremium {



    public CalculatePremiumImpl() {
    }

    @Override
    public double calculatePremium(Customer customer, int premium) {
        int age = customer.getAge();

        if (customer.isSex()){
            //남자일 경우
            return (age / 5) * premium;

        }

        return (age / 3) * premium;
    }
}
