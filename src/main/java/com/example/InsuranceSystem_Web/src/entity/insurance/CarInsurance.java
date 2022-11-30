package com.example.InsuranceSystem_Web.src.entity.insurance;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.SQLDelete;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.time.LocalDateTime;

@Entity
@DiscriminatorValue("C")
@NoArgsConstructor
@Getter
@SuperBuilder
public class CarInsurance extends Insurance{

  private Integer humanDamageBasicMoney;
  private Integer carDamageBasicMoney;


  public CarInsurance(String name, String explanation, int premium, LocalDateTime createdDate,
                      int humanDamageBasicMoney, int carDamageBasicMoney) {
    super(name, explanation, premium, createdDate);
    this.humanDamageBasicMoney = humanDamageBasicMoney;
    this.carDamageBasicMoney = carDamageBasicMoney;
  }
}
