package com.example.InsuranceSystem_Web.src.vo.customer;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetCustomerCountVo {
    @ApiModelProperty(notes = "총 보험가입자 수", example = "0")
    private int TotalCustomerCount;
    @ApiModelProperty(notes = "이달의 가입한 보험가입자 수", example = "0")
    private int ThisMonthCustomerCount;
    @ApiModelProperty(notes = "이달의 보험료 미납한 보험가입자 수", example = "0")
    private int ThisMonthNotPayCustomerCount;
}
