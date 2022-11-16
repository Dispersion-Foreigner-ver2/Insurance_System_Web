package com.example.InsuranceSystem_Web.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;


@Getter @Setter
@NoArgsConstructor
public class StaffLoginForm {

    @NotBlank(message = "아이디를 입력해주세요.")
    private String staffId;

    @NotBlank(message = "비밀번호를 입력해주세요.")
    private String password;

}
