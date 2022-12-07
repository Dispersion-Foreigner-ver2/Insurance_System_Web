package com.example.InsuranceSystem_Web.src.dto.contract;

import com.example.InsuranceSystem_Web.src.entity.customer.enums.ShipType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostSeaContractDto extends PostContractDto{
    private int shipNum;
    private int year;
    private int price;
    private int shipType;
}
