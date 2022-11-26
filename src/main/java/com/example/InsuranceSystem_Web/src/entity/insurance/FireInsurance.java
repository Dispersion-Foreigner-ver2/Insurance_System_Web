package com.example.InsuranceSystem_Web.src.entity.insurance;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@DiscriminatorValue("F")
@NoArgsConstructor
@Getter @SuperBuilder
public class FireInsurance extends Insurance{

  private int surroundingDamageBasicMoney;
  private int humanDamageBasicMoney;
  private int buildingDamageBasicMoney;


  public FireInsurance(String name, String explanation, int premium, boolean authorization, LocalDateTime authorizationDate, LocalDateTime createdDate, LocalDateTime modifiedDate, int surroundingDamageBasicMoney, int humanDamageBasicMoney, int buildingDamageBasicMoney) {
    super(name, explanation, premium, authorization, authorizationDate, createdDate, modifiedDate);
    this.surroundingDamageBasicMoney = surroundingDamageBasicMoney;
    this.humanDamageBasicMoney = humanDamageBasicMoney;
    this.buildingDamageBasicMoney = buildingDamageBasicMoney;
  }
}
