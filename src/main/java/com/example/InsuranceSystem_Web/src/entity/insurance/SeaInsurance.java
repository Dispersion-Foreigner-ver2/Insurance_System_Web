package com.example.InsuranceSystem_Web.src.entity.insurance;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.time.LocalDateTime;

@Entity
@DiscriminatorValue("S")
@NoArgsConstructor
@Getter
@SuperBuilder
@Setter
public class SeaInsurance extends Insurance{

  //제반 손해 보상금
  private Integer generalDamageBasicMoney;
  //수익 손해 보상금
  private Integer revenueDamageBasicMoney;

  public SeaInsurance(String name, String explanation, int premium,LocalDateTime createdDate,
                      int generalDamageBasicMoney, int revenueDamageBasicMoney) {
    super(name, explanation, premium, createdDate);
    this.generalDamageBasicMoney = generalDamageBasicMoney;
    this.revenueDamageBasicMoney = revenueDamageBasicMoney;
  }
}
