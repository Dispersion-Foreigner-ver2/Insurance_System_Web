package com.example.InsuranceSystem_Web.src.insurance.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class FireInsurance{

  /**
   * CarInsurance IDX
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private int surroundingDamageBasicMoney;
  private int humanDamageBasicMoney;
  private int buildingDamageBasicMoney;

  @OneToOne
  @JoinColumn(name = "Insurance_ID")
  private Insurance insurance;

  @Builder
  public FireInsurance(int surroundingDamageBasicMoney, int humanDamageBasicMoney,
                      int buildingDamageBasicMoney,Insurance insurance){
    this.surroundingDamageBasicMoney = surroundingDamageBasicMoney;
    this.humanDamageBasicMoney = humanDamageBasicMoney;
    this.buildingDamageBasicMoney = buildingDamageBasicMoney;
    this.insurance = insurance;
  }

}
