package com.example.InsuranceSystem_Web.src.dto.contract;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
public class PostFireContractDto extends PostContractDto {
    @ApiParam(value = "건물 종류", example = "0")
    @NotNull(message = "건물 종류를 입력하세요.")
    private int houseType;

    @ApiParam(value = "건물 가격", example = "0")
    @NotNull(message = "건물 가격을 입력하세요.")
    private int housePrice;
}
