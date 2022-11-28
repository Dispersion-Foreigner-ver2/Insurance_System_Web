package com.example.InsuranceSystem_Web.src.controller;


import com.example.InsuranceSystem_Web.src.dto.customer.PostCustomerJoinDto;
import com.example.InsuranceSystem_Web.src.service.customer.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.naming.Binding;
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

        model.addAttribute("customerJoinForm", new PostCustomerJoinDto());
      //  return "customerJoin";
        return null;
    }

    @PostMapping("/customerJoin")
    private String join(@Valid PostCustomerJoinDto postCustomerJoinDto, BindingResult result){

        if (result.hasErrors()) {
            return "customerJoin";
        }

        customerService.join(postCustomerJoinDto);


        return "customerJoin";

    }


}
