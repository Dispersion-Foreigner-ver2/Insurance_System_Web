package com.example.InsuranceSystem_Web.src.vo.contract;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostContractManageVo {
// private Long customerId;
// private Long insuranceId;
 private Long insuranceId;
 private String InsuranceName;
 private String insuranceType;
 private int insuranceResignCount;

}
