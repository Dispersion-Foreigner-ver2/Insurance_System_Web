package com.example.InsuranceSystem_Web.src.dto.contract;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostCarContractDto extends PostContractDto{
    @ApiParam(value = "자동차 번호")
    @ApiModelProperty(example = "123456")
    private int carNum;
    @ApiModelProperty(example = "2019")
    @ApiParam(value = "자동차 연식")
    private int year;
    @ApiModelProperty(example = "500")
    @ApiParam(value = "자동차 배기량")
    private int displacement;
    @ApiModelProperty(example = "30000000")
    @ApiParam(value = "자동차 가격")
    private int price;
}
