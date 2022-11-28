package com.example.InsuranceSystem_Web.src.entity.customer;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Getter @Setter
public class Customer {



	public static enum Job {
		영업직(70, false),
		생산직(60, true),
		사무직(75, false),
		자영업자(70, true),
		무직(30, false);

		private int maxAge;
		private boolean danger;

		private Job(int maxAge, boolean danger) {
			this.maxAge = maxAge;
			this.danger = danger;
		}

		public int getMaxAge() {
			return this.maxAge;
		}

		public boolean isDanger() {
			return this.danger;
		}
	}

	@Id
	@Column(name = "customer_id")
	private int id;

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

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "medicalHistory_id")
	private MedicalHistory medicalHistory;

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
