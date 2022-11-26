package com.example.InsuranceSystem_Web.src.entity.customer;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
@AllArgsConstructor
public class Ship {
  @Id
  @Column(name="ship_id")
  private Long id;
  @OneToOne(mappedBy = "ship",fetch = FetchType.LAZY)
  private Customer customer;
  private int shipNum;
  private int year;
  private int price;
  public enum ShipType {
    General,
    Container;
  }
  private ShipType shipType;
  private int customer_id;



  public Ship() {
  }

  public int getShipNum() {
    return this.shipNum;
  }

  public void setShipNum(int shipNum) {
    this.shipNum = shipNum;
  }

  public int getYear() {
    return this.year;
  }

  public void setYear(int year) {
    this.year = year;
  }

  public int getPrice() {
    return this.price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public ShipType getShipType() {
    return this.shipType;
  }

  public void setShipType(ShipType shipType) {
    this.shipType = shipType;
  }

  public int getCustomerId() {
    return this.customer_id;
  }

  public void setCustomerId(int customer_id) {
    this.customer_id = customer_id;
  }


}