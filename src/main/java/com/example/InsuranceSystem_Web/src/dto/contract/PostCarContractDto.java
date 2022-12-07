package com.example.InsuranceSystem_Web.src.dto.contract;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostCarContractDto extends PostContractDto{
    private int carNum;
    private int year;
    private int displacement;
    private int price;
}
