package com.example.InsuranceSystem_Web.src.dto.contract;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

//보험 계약을 관리한다

@Getter
@Setter
@NoArgsConstructor
public class PostContractSearchDto {
    @NotBlank(message = "고객 아이디를 입력해주세요.")
    private  Long customerId;

    @NotBlank(message = "보험 가입자 아이디를 입력해주세요.")
    private Long insuranceId;


    }









