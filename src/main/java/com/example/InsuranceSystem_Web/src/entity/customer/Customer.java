package com.example.InsuranceSystem_Web.src.entity.customer;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
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
	private Date joinDate;
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "house_id")
	private House house;
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "car_id")
	private Car car;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "car_id")
	private Ship ship;


	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Job getJob() {
		return this.job;
	}

	public void setJob(Job job) {
		this.job = job;
	}


	public Date getJoinDate() {
		return this.joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	public String getAccount() {
		return this.account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public MedicalHistory getMedicalHistory() {
		return this.medicalHistory;
	}

	public void setMedicalHistory(MedicalHistory medicalHistory) {
		this.medicalHistory = medicalHistory;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public boolean isSex() {
		return this.sex;
	}

	public void setSex(boolean sex) {
		this.sex = sex;
	}

	public String getSSN() {
		return this.SSN;
	}

	public void setSSN(String SSN) {
		this.SSN = SSN;
	}

	public House getHouse() {
		return this.house;
	}

	public void setHouse(House house) {
		this.house = house;
	}

	public Car getCar() {
		return this.car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public Ship getShip() {
		return this.ship;
	}

	public void setShip(Ship ship) {
		this.ship = ship;
	}


}