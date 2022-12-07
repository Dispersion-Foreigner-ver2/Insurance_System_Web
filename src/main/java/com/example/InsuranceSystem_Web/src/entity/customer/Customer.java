package com.example.InsuranceSystem_Web.src.entity.customer;


import com.example.InsuranceSystem_Web.src.entity.customer.enums.Job;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Customer {

	@Id
	@Column(name = "customer_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "customer_age")
	private int age;

	@Column(name = "customer_account")
	private String account;

	@Column(name = "customer_address")
	private String address;

	@Column(name = "customer_email")
	private String email;

	@Enumerated(EnumType.STRING)
	@Column(name = "customer_job")
	private Job job;

	@Column(name = "customer_name")
	private String name;

	@Column(name = "customer_phoneNumber")
	private String phoneNumber;

	@Column(name = "customer_sex")
	private boolean sex;

	@Column(name = "customer_SSN")
	private String SSN;

	@Column(name = "customer_joinDate")
	private LocalDate joinDate;

}
