package com.example.InsuranceSystem_Web.Domain.Insurance;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
//@Entity
public abstract class Insurance {

//    /**
//     * Insurance IDX
//     */
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String explanation;
    private int premium;
    public boolean authorization;
    private Date authorizationDate;
    private Date createdDate;
    private Date modifiedDate;

//    @Enumerated(EnumType.ORDINAL) // 숫자
    private Type type;

    public enum Type {
        Fire,
        Car,
        Sea;
    }

    public Insurance() {

    }

}
