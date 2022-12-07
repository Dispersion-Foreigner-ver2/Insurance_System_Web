package com.example.InsuranceSystem_Web.src.service.customer;

import com.example.InsuranceSystem_Web.src.vo.customer.GetCustomerCountVo;
import com.example.InsuranceSystem_Web.src.vo.customer.GetCustomerVo;

import java.util.List;

public interface CustomerService {


    GetCustomerCountVo readCustomerCount();

   List<GetCustomerVo> readDetailCustomer();

}
