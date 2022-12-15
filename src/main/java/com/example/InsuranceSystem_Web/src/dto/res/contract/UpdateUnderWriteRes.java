package com.example.InsuranceSystem_Web.src.dto.res.contract;

import com.example.InsuranceSystem_Web.src.entity.contract.Contract;
import com.example.InsuranceSystem_Web.src.entity.customer.MedicalHistory;
import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class UpdateUnderWriteRes {
    private String message;

    private Long customerId;
    private String customerName;
    private String job;
    private String disease;

    public static UpdateUnderWriteRes of(Contract contract, MedicalHistory medicalHistory){
        return UpdateUnderWriteRes.builder()
                .message("해당 고객은 위험 직업군이 아닙니다. " +
                        "해당 고객은 보험 가입에 제한되는 병력이 없습니다. " +
                        "인수심사가 통과되었습니다! " +
                        "보험 가입이 완료되었습니다.")
                .customerId(contract.getContractId())
                .job(contract.getCustomer().getJob().name())
                .disease(medicalHistory.getMyDisease().name())
                .build();
    }
}
