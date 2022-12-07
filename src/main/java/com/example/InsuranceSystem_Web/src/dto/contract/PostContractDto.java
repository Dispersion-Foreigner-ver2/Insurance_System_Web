package com.example.InsuranceSystem_Web.src.dto.contract;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
public class PostContractDto {
    @NotNull(message = "계약을 진행 할 보험 ID를 입력해 주세요.")
    private Long insuranceId;

    @NotBlank(message = "고객 이름을 입력하세요.")
    private String name;

    @NotBlank(message = "고객의 주민등록번호를 입력하세요.")
    private String ssn;

    @NotBlank(message = "고객의 주소를 입력하세요.")
    private String address;

    @NotBlank(message = "고객의 전화번호를 입력하세요.")
    private String phoneNum;

    @NotBlank(message = "고객의 이메일을 입력하세요.")
    private String email;

    @NotBlank(message = "고객의 계좌번호를 입력하세요.")
    private String account;

    @NotNull(message = "고객의 성별을 입력하세요.")
    private int customerSex;

    @NotNull(message = "고객의 나이를 입력하세요.")
    private int age;

    @NotNull(message = "고객의 직업을 입력하세요.")
    private int job;

    @NotNull(message = "고객의 병력을 입력하세요.")
    private int diseaseNum;

    @NotNull(message = "고객의 병력 발병 년도를 입력하세요.")
    private int customerMedicalYear;

    @NotNull(message = "고객의 완치 여부를 입력하세요.")
    public int cureComplete;

}
