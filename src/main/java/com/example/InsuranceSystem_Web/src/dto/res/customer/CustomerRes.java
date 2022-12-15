package com.example.InsuranceSystem_Web.src.dto.res.customer;

import com.example.InsuranceSystem_Web.src.entity.customer.enums.Job;
import com.example.InsuranceSystem_Web.src.entity.customer.MedicalHistory;

import java.time.LocalDate;
import java.util.Objects;

public class CustomerRes {

    private Long id;
    private int age;
    private String account;
    private String address;
    private String email;
    private Job job;
    private MedicalHistory medicalHistory;
    private String name;
    private String phoneNumber;
    private boolean sex;
    private String SSN;
    private LocalDate joinDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerRes that = (CustomerRes) o;
        return age == that.age && sex == that.sex && Objects.equals(id, that.id) && Objects.equals(account, that.account) && Objects.equals(address, that.address) && Objects.equals(email, that.email) && job == that.job && Objects.equals(medicalHistory, that.medicalHistory) && Objects.equals(name, that.name) && Objects.equals(phoneNumber, that.phoneNumber) && Objects.equals(SSN, that.SSN) && Objects.equals(joinDate, that.joinDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, age, account, address, email, job, medicalHistory, name, phoneNumber, sex, SSN, joinDate);
    }
}
