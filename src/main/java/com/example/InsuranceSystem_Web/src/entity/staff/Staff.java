package com.example.InsuranceSystem_Web.src.entity.staff;

import lombok.*;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Builder
@AllArgsConstructor
public class Staff {

  @Id
  @Column(name = "staff_id")
  private long id;

  private String password;

  @Column(name = "staff_email")
  private String email;
  private boolean gender;

  private LocalDate joinDate;
  @Column(name = "staff_name")
  private String name;
  @Column(name = "staff_phone_num")
  private String phoneNum;
  @Column(name = "staff_SSN")
  private String SSN;

  @Enumerated(EnumType.STRING)
  private Department department;

  @Enumerated(EnumType.STRING)
  private Position position;

  @Nullable
  private int basicSalary;
  @Nullable
  private int totalSalary;
  @Nullable
  private int result; //실적


  protected Staff() {

  }
}
