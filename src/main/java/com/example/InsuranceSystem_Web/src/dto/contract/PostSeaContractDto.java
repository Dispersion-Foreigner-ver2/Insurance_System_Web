package com.example.InsuranceSystem_Web.src.dto.contract;

import com.example.InsuranceSystem_Web.src.entity.customer.enums.ShipType;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostSeaContractDto extends PostContractDto{
    @ApiParam(value = "선박 번호", example = "0")
    private int shipNum;
    @ApiParam(value = "선박 연식", example = "0")
    private int year;
    @ApiParam(value = "선박 가격", example = "0")
    private int price;
    @ApiParam(value = "선박 종류 입력란 (1: General ,2: Container)", example = "0")
    private int shipType;
}
