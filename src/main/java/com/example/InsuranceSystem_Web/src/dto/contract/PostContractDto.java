package com.example.InsuranceSystem_Web.src.dto.contract;


import com.example.InsuranceSystem_Web.src.entity.contract.Contract;
import com.example.InsuranceSystem_Web.src.entity.insurance.CarInsurance;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

//보험 계약을 관리한다

@Getter
@Setter
@NoArgsConstructor
public class PostContractDto {
    @NotBlank(message = "고객 아이디를 입력해주세요.")
    private  Long customerId;

    @NotBlank(message = "보험 아이디를 입력해주세요.")
    private Long insuranceId;


    }









