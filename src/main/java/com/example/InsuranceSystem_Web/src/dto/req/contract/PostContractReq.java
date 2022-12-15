package com.example.InsuranceSystem_Web.src.dto.req.contract;

import io.swagger.annotations.ApiParam;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
public class PostContractReq {
    @ApiParam(value= "보험 ID", example = "0")
    @NotNull(message = "계약을 진행 할 보험 ID를 입력해 주세요.")
    private Long insuranceId;

    @ApiParam(value = "고객 이름")
    @NotBlank(message = "고객 이름을 입력하세요.")
    private String name;

    @ApiParam(value = "주민등록번호")
    @NotBlank(message = "고객의 주민등록번호를 입력하세요.")
    private String ssn;

    @ApiParam(value = "고객주소")
    @NotBlank(message = "고객의 주소를 입력하세요.")
    private String address;

    @ApiParam(value = "전화번호")
    @NotBlank(message = "고객의 전화번호를 입력하세요.")
    private String phoneNum;

    @ApiParam(value = "이메일")
    @NotBlank(message = "고객의 이메일을 입력하세요.")
    private String email;

    @ApiParam(value = "계좌번호")
    @NotBlank(message = "고객의 계좌번호를 입력하세요.")
    private String account;

    @ApiParam(value = "고객성별", example = "0")
    @NotNull(message = "고객의 성별을 입력하세요.")
    private int customerSex;

    @ApiParam(value = "고객나이", example = "0")
    @NotNull(message = "고객의 나이를 입력하세요.")
    private int age;

    @ApiParam(value = "고객직업", example = "0")
    @NotNull(message = "고객의 직업을 입력하세요.")
    private int job;

    @ApiParam(value = "고객의 병력", example = "0")
    @NotNull(message = "고객의 병력을 입력하세요.")
    private int diseaseNum;

    @ApiParam(value = "객의 병력 발병 년도", example = "0")
    @NotNull(message = "고객의 병력 발병 년도를 입력하세요.")
    private int customerMedicalYear;

    @ApiParam(value = "고객의 완치 여부", example = "0")
    @NotNull(message = "고객의 완치 여부를 입력하세요.")
    public int cureComplete;

}
