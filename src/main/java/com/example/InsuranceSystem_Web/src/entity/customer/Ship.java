package com.example.InsuranceSystem_Web.src.entity.customer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class Ship {
  @Id
  @Column(name="ship_id")
  private int id;

  private int shipNum;
  private int year;
  private int price;

  public enum ShipType {
    General,
    Container;
  }
  @Enumerated(EnumType.STRING)
  private ShipType shipType;


  @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private Customer customer;

}
