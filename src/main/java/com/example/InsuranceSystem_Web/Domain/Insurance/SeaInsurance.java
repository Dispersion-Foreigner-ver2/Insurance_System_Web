package com.example.InsuranceSystem_Web.Domain.Insurance;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

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
