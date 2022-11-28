package com.example.InsuranceSystem_Web.src.entity.customer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class MedicalHistory {

	@Id
	@Column(name="medicalHistory_id")
	private int id;

	private boolean cureComplete;
	private int historyYear;

	@Enumerated(EnumType.STRING)
	private Disease MyDisease;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Customer customer;

	public enum Disease {
		암(false),
		결핵(true),
		수두(true),
		홍역(true),
		없음(true);

		private boolean pass;

		private Disease(boolean pass) {
			this.pass = pass;
		}

		public boolean isPass() {
			return this.pass;
		}
	}
}
