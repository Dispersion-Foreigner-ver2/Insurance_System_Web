package com.example.InsuranceSystem_Web.src.dto.req.compensation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostCarDisclaimerReq {
    private int subject;
    private int carCause;
}
