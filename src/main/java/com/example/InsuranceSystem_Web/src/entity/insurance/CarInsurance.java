package com.example.InsuranceSystem_Web.src.entity.insurance;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.time.LocalDateTime;

@Entity
@DiscriminatorValue("C")
@NoArgsConstructor
@Getter @SuperBuilder
public class CarInsurance extends Insurance{


  private int humanDamageBasicMoney;
  private int carDamageBasicMoney;



  public CarInsurance(String name, String explanation, int premium,
                      boolean authorization, LocalDateTime authorizationDate,
                      LocalDateTime createdDate, LocalDateTime modifiedDate, int humanDamageBasicMoney, int carDamageBasicMoney) {
    super(name, explanation, premium, authorization, authorizationDate, createdDate, modifiedDate);
    this.humanDamageBasicMoney = humanDamageBasicMoney;
    this.carDamageBasicMoney = carDamageBasicMoney;
  }
}
