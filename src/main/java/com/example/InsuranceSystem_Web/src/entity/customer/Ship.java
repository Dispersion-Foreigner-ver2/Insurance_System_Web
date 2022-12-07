package com.example.InsuranceSystem_Web.src.entity.customer;

import com.example.InsuranceSystem_Web.src.entity.customer.enums.ShipType;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class Ship {
  @Id
  @Column(name="ship_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private int shipNum;
  private int year;
  private int price;

  @Enumerated(EnumType.STRING)
  private ShipType shipType;

  @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private Customer customer;

}
