package com.example.InsuranceSystem_Web.src.entity.contract;

import com.example.InsuranceSystem_Web.src.entity.customer.Customer;
import com.example.InsuranceSystem_Web.src.entity.insurance.Insurance;
import com.example.InsuranceSystem_Web.src.entity.staff.Staff;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Contract {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="contract_id")
	private Long contractId;

	private int insurancePrice;
	private int premiumRate;//보험율
	private double compensationAmount;//총 보상액

	private Date contractDate;
	private boolean underWrite;//인수심사 -> 받으면 계약o 안되면 계약x
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

	public Contract(Long contractId){
		this.contractId=contractId;
	}

}
