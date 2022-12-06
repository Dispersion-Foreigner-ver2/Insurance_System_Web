package com.example.InsuranceSystem_Web.src.dto.contract;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
public class PostContractConclusionDto {
    @NotBlank(message = "고객 이름을 입력하세요.")
    private String customerName;

    @NotBlank(message = "고객의 주민등록번호를 입력하세요.")
    private int customerResidentNumber;

    @NotBlank(message = "고객의 주소를 입력하세요.")
    private String customerAddress;

    @NotBlank(message = "고객의 전화번호를 입력하세요.")
    private int customerNumber;

    @NotBlank(message = "고객의 이메일을 입력하세요.")
    private String customerEmail;

    @NotBlank(message = "고객의 계좌번호를 입력하세요.")
    private int customerAccount;

    @NotBlank(message = "고객의 성별을 입력하세요.")
    private boolean customerSex;

    @NotBlank(message = "고객의 나이를 입력하세요.")
    private int customerAge;

    @NotBlank(message = "고객의 직업을 입력하세요.")
    private String customerJob;

    @NotBlank(message = "고객의 병력을 입력하세요.")
    private String customerMedicalHistory;

    @NotBlank(message = "고객의 병력 발병 년도를 입력하세요.")
    private int customerMedicalYear;

    @NotBlank(message = "고객의 완치 여부를 입력하세요.")
    private boolean customerRecovery;

    @NotBlank(message = "건물 종류를 입력하세요.")
    private String typeOfBuilding;

    @NotBlank(message = "건물 가격을 입력하세요.")
    private int buildingPrice;


}
