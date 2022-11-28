package com.example.InsuranceSystem_Web.src.entity.customer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class House {

  @Id
  @Column(name = "house_id")
  private int id;

  @Enumerated(EnumType.STRING)
  private HouseType houseType;

  private int price;
  private int customerId;

  @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private Customer customer;

  public enum HouseType {
    apartment,
    housing,
    officetels
  }


}
