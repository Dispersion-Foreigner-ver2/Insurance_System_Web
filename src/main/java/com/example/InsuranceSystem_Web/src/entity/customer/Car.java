package com.example.InsuranceSystem_Web.src.entity.customer;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class Car {

  @Id
  @Column(name = "car_id")
  private int carId;

  private int carNum;
  private int year;
  private int displacement;
  private int price;

  @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private Customer customer;
}
