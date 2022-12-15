package com.example.InsuranceSystem_Web.src.dto.res.customer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetCustomerRes {
    private Long customerId;
    private String ssn;
    private String address;
    private String phoneNumber;
    private String email;
    private String insuranceName;
    private boolean MonthPay;

//    public static GetCustomerVo of(Contract contract){
//        return GetCustomerVo.builder()
//                .customerId(contract.getCustomer().getId())
//                .ssn(contract.getCustomer().getSSN())
//                .address(contract.getCustomer().getAddress())
//                .email(contract.getCustomer().getEmail())
//                .insuranceName(contract.getInsurance().getName())
//                .build();
//    }


}
