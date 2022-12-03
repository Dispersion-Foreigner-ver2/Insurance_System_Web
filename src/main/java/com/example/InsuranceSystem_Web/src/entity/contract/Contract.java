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
	@Column(name="contract_id")
	private Long contractId;

	private int insurancePrice;
	private int premiumRate; // 보험 요율
	private double compensationAmount; // 보상액

	private Date contractDate;
	private boolean underWrite; // 인수 심사  - false
	private boolean pay; // 보상 유무 - false

	@ManyToOne
	@JoinColumn(name="customer_id")
	public Customer customer;

	@OneToOne
	@JoinColumn(name="insurance_id")
	public Insurance insurance;

	@OneToOne
	@JoinColumn(name="staff_id")
	public Staff staff;

	public Contract(Long contractId){
		this.contractId=contractId;
	}

}
