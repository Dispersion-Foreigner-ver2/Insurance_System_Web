package com.example.InsuranceSystem_Web.src.insurance.entity;

import lombok.*;
import com.example.InsuranceSystem_Web.src.insurance.entity.Insurance;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SeaInsurance{

  /**
   * CarInsurance IDX
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  /**
   * 제반 손해 정도
   */
  private int generalDamageBasicMoney;
  /**
   * 수익 손해 정도
   */
  private int revenueDamageBasicMoney;

  @OneToOne
  @JoinColumn(name = "Insurance_ID")
  private Insurance insurance;

  @Builder
  public SeaInsurance(int generalDamageBasicMoney,int revenueDamageBasicMoney,Insurance insurance){
    this.generalDamageBasicMoney = generalDamageBasicMoney;
    this.revenueDamageBasicMoney = revenueDamageBasicMoney;
    this.insurance = insurance;
  }
}
