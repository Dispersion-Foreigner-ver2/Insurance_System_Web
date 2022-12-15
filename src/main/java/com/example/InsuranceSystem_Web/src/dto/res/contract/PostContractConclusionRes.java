package com.example.InsuranceSystem_Web.src.dto.res.contract;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostContractConclusionRes {
    @ApiModelProperty(example = "계약서 작성이 완료되었습니다. 인수 심사 후 최종 가입 여부가 결정됩니다.")
    private String message;
    private Long contractId;
}
