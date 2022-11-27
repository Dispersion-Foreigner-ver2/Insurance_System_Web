package com.example.InsuranceSystem_Web.src.dto.customer;

import com.example.InsuranceSystem_Web.src.entity.customer.Car;
import com.example.InsuranceSystem_Web.src.entity.customer.House;
import com.example.InsuranceSystem_Web.src.entity.customer.MedicalHistory;
import com.example.InsuranceSystem_Web.src.entity.customer.Ship;
import com.example.InsuranceSystem_Web.src.entity.staff.Department;
import com.example.InsuranceSystem_Web.src.entity.staff.Position;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
public class CustomerJoinForm {
    @NotBlank(message = "고객 아이디를 입력해주세요.")
    private String id;

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

    private Car car;

    private House house;

    private MedicalHistory medicalHistory;

    private Ship ship;

    private int customerSex;



}
