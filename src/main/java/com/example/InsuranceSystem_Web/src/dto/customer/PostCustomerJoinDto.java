package com.example.InsuranceSystem_Web.src.dto.customer;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
public class PostCustomerJoinDto {
    @NotBlank(message = "고객 아이디를 입력해주세요.")
    private Long id;

    @NotBlank(message = "고객 이름을 입력해주세요.")
    private String name;

    @NotBlank(message = "고객의 SSN를 입력해주세요.")
    private String ssn;

    @NotBlank(message = "고객 주소를 입력해주세요.")
    private String address;

    @NotBlank(message = "고객 번호를 입력해주세요.")
    private String phoneNum;

    @NotBlank(message = "고객 이메일을 입력해주세요.")
    private String email;

    @NotBlank(message = "고객 계정 입력해주세요.")
    private String account;

    private int customerSex;

    // MedicalHistory
    public int diseaseNum;

    private int historyYear;  // default : 0

    public int cureComplete; // 치료완료

}
