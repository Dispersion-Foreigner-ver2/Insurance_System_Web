package com.example.InsuranceSystem_Web.src.entity.customer;

import com.example.InsuranceSystem_Web.src.entity.customer.enums.HouseType;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class House {

  @Id
  @Column(name = "house_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Enumerated(EnumType.STRING)
  private HouseType houseType;

  private int price;

  @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private Customer customer;

}
