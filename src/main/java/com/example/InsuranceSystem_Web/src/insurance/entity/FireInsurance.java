package com.example.InsuranceSystem_Web.src.insurance.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//@Entity
public class FireInsurance extends Insurance{

//  /**
//   * CarInsurance IDX
//   */
//  @Id
//  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private int surroundingDamageBasicMoney;
  private int humanDamageBasicMoney;
  private int buildingDamageBasicMoney;
//
//  @OneToOne
//  @JoinColumn(name = "Insurance_ID")
//  private Insurance insurance;

}
