package com.example.InsuranceSystem_Web.src.vo.contract;

import com.example.InsuranceSystem_Web.src.entity.insurance.Insurance;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostContractConclusionVo {
    @ApiModelProperty(example = "계약서 작성이 완료되었습니다. 인수 심사 후 최종 가입 여부가 결정됩니다.")
    private String message;
    private Long contractId;
}
