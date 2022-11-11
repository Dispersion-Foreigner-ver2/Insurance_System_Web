package com.example.InsuranceSystem_Web.Domain.Insurance;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

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
