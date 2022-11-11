package com.example.InsuranceSystem_Web.src.Domain.Insurance;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//@Entity
public class SeaInsurance extends Insurance {

//  /**
//   * CarInsurance IDX
//   */
//  @Id
//  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  /**
   * 제반 손해 정도
   */
  private int generalDamageBasicMoney;
  /**
   * 수익 손해 정도
   */
  private int revenueDamageBasicMoney;
//
//  @OneToOne
//  @JoinColumn(name = "Insurance_ID")
//  private Insurance insurance;

}
