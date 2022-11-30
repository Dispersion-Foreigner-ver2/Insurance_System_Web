package com.example.InsuranceSystem_Web.src.entity.contract;

import com.example.InsuranceSystem_Web.src.entity.customer.Customer;
import com.example.InsuranceSystem_Web.src.entity.insurance.Insurance;
import com.example.InsuranceSystem_Web.src.entity.staff.Staff;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Contract {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long contractId;

	private int insurancePrice;
	private int premiumRate;
	private double compensationAmount;

	private Date contractDate;
	private boolean underWrite;
	private boolean pay;

	@ManyToOne
	@JoinColumn(name="customer_id")
	public Customer customer;

	@OneToOne
	@JoinColumn(name="insurance_id")
	public Insurance insurance;

	@OneToOne
	@JoinColumn(name="staff_id")
	public Staff staff;

}
