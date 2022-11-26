package com.example.InsuranceSystem_Web.src.controller;


import com.example.InsuranceSystem_Web.src.dto.customer.CustomerJoinForm;
import com.example.InsuranceSystem_Web.src.dto.staff.StaffJoinForm;
import com.example.InsuranceSystem_Web.src.entity.customer.Customer;
import com.example.InsuranceSystem_Web.src.entity.staff.Staff;
import com.example.InsuranceSystem_Web.src.service.customer.CustomerService;
import com.example.InsuranceSystem_Web.src.service.staff.StaffService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
@Slf4j
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customerJoin")
    private String join(Model model) {

        model.addAttribute("customerJoinForm", new CustomerJoinForm());
        return "customerJoin";
    }

    @PostMapping("/customerJoin")
    private String join(@Valid String customerName, String customerSSN, String customerAddress, String customerPhoneNum, String customerEmail, String customerAccount, int customerAge, int customerSex, int customerJob, int customerDisease, int customerHistoryYear, int customerCureComplete, BindingResult result) throws Exception {

        if (result.hasErrors()) {
            return "customerJoin";
        }

        customerService.joinCustomer(customerName,  customerSSN,  customerAddress,  customerPhoneNum,  customerEmail,  customerAccount,  customerAge,  customerSex,  customerJob,  customerDisease,  customerHistoryYear,  customerCureComplete);


        return "customerJoin";

    }


}