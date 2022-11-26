package com.example.InsuranceSystem_Web.src.entity.insurance;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@DiscriminatorValue("C")
@NoArgsConstructor
@Getter @SuperBuilder
public class SeaInsurance extends Insurance{

  //제반 손해 보상금
  private int generalDamageBasicMoney;
  //수익 손해 보상금
  private int revenueDamageBasicMoney;

  public SeaInsurance(String name, String explanation, int premium, boolean authorization, LocalDateTime authorizationDate, LocalDateTime createdDate, LocalDateTime modifiedDate, int generalDamageBasicMoney, int revenueDamageBasicMoney) {
    super(name, explanation, premium, authorization, authorizationDate, createdDate, modifiedDate);
    this.generalDamageBasicMoney = generalDamageBasicMoney;
    this.revenueDamageBasicMoney = revenueDamageBasicMoney;
  }
}
