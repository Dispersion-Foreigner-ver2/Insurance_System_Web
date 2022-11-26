package com.example.InsuranceSystem_Web.src.entity.customer;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
@AllArgsConstructor
public class House {

  @Id
  @Column(name = "house_id")
  private Long id;

  @OneToOne(mappedBy = "house",fetch = FetchType.LAZY)
  private Customer customer;
  public enum HouseType {
    apartment,
    housing,
    officetels
  }
  private HouseType houseType;
  private int price;
  private int customerId;

  public House() {
  }

  public HouseType getHouseType() {
    return this.houseType;
  }

  public void setHouseType(HouseType houseType) {
    this.houseType = houseType;
  }

  public int getPrice() {
    return this.price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public int getCustomerId() {
    return this.customerId;
  }

  public void setCustomerId(int customer_id) {
    this.customerId = customer_id;
  }


}
