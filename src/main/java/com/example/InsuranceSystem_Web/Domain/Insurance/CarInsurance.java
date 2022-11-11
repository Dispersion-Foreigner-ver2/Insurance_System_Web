package com.example.InsuranceSystem_Web.Domain.Insurance;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
//@Entity
public class CarInsurance extends Insurance {

//  /**
//   * CarInsurance IDX
//   */
//  @Id
//  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private int humanDamageBasicMoney;
  private int carDamageBasicMoney;

//  @OneToOne
//  @JoinColumn(name = "Insurance_ID")
//  private Insurance insurance;

}
