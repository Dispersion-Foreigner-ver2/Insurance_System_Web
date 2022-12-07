package com.example.InsuranceSystem_Web.src.vo.contract;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DeleteContractTerminateVo {
    @ApiModelProperty(example = "보험 계약 해지가 완료되었습니다.")
    private String message;
    private LocalDate localDate;
}
