package com.example.InsuranceSystem_Web.src.entity.Insurance;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CarInsurance{

  /**
   * CarInsurance IDX
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private int humanDamageBasicMoney;
  private int carDamageBasicMoney;

  @OneToOne
  @JoinColumn(name = "Insurance_ID")
  private Insurance insurance;

  @Builder
  public CarInsurance(int humanDamageBasicMoney, int carDamageBasicMoney, Insurance insurance) {
    this.humanDamageBasicMoney = humanDamageBasicMoney;
    this.carDamageBasicMoney = carDamageBasicMoney;
    this.insurance = insurance;
  }
}
