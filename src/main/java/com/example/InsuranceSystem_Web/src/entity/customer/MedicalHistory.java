package com.example.InsuranceSystem_Web.src.entity.customer;

import com.example.InsuranceSystem_Web.src.entity.customer.enums.Disease;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MedicalHistory {

	@Id
	@Column(name="medicalHistory_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private boolean cureComplete;
	private int historyYear;

	@Enumerated(EnumType.STRING)
	private Disease MyDisease;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Customer customer;
}
