package com.example.InsuranceSystem_Web.src.vo.contract;

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
    private String message;
    private LocalDate localDate;
}
