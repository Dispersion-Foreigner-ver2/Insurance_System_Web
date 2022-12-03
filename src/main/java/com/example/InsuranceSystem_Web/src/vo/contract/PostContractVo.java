package com.example.InsuranceSystem_Web.src.vo.contract;

import com.example.InsuranceSystem_Web.src.entity.insurance.Insurance;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostContractVo {
// private Long customerId;
// private Long insuranceId;
 private Long insuranceId;
 private String InsuranceName;
 private String insuranceType;
 private int insuranceResignCount;

}
