package com.example.InsuranceSystem_Web.src.service.customer;

import com.example.InsuranceSystem_Web.src.dto.res.customer.GetCustomerCountRes;
import com.example.InsuranceSystem_Web.src.dto.res.customer.GetCustomerRes;

import java.util.List;

public interface CustomerService {


    GetCustomerCountRes readCustomerCount();

   List<GetCustomerRes> readDetailCustomer();

}
