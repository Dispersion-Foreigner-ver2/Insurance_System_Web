package com.example.InsuranceSystem_Web.src.entity.customer;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class Car {

  @Id
  @Column(name = "car_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int carId;

  private int carNum;
  private int year;
  private int displacement;
  private int price;

  @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private Customer customer;
}
