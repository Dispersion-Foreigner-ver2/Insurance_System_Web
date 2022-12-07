package com.example.InsuranceSystem_Web.src.dto.contract;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
public class PostFireContractDto extends PostContractDto {
    @NotNull(message = "건물 종류를 입력하세요.")
    private int houseType;
    @NotNull(message = "건물 가격을 입력하세요.")
    private int housePrice;
}
