package com.example.InsuranceSystem_Web.src.dto.req.contract;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostCarContractReq extends PostContractReq {
    @ApiParam(value = "자동차 번호", example = "0")
    @ApiModelProperty(example = "123456")
    private int carNum;

    @ApiModelProperty(example = "2019")
    @ApiParam(value = "자동차 연식", example = "0")
    private int year;

    @ApiModelProperty(example = "500")
    @ApiParam(value = "자동차 배기량", example = "0")
    private int displacement;

    @ApiModelProperty(example = "30000000")
    @ApiParam(value = "자동차 가격", example = "0")
    private int price;
}
