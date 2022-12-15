package com.example.InsuranceSystem_Web.src.dto.res.customer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class getPayRes {
    private String name;
    private String ssn;
    private String address;
    private String phoneNumber;
    private String email;
    private String insuranceName;
    private int NotPayMoney;
}
