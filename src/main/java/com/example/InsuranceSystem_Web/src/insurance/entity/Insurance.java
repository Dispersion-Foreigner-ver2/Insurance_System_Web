package com.example.InsuranceSystem_Web.src.insurance.entity;

import io.swagger.models.auth.In;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Insurance {

    /**
     * Insurance IDX
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int insuranceId;

    private String name;
    private String explanation;
    private int premium;

    public boolean authorization;
    private LocalDateTime authorizationDate;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    @Enumerated(EnumType.STRING)
    private Type type;

    public enum Type {
        Fire,
        Car,
        Sea;
    }

    @Builder
    public Insurance(String name, String explanation, int premium,
                     boolean authorization, LocalDateTime authorizationDate,
                     LocalDateTime createdDate,LocalDateTime modifiedDate, Type type ){
        this.name = name;
        this.explanation = explanation;
        this.premium =premium;
        this.authorization =authorization;
        this.authorizationDate = authorizationDate;
        this.createdDate =createdDate;
        this.modifiedDate = modifiedDate;
        this.type = type;
    }

    public static Insurance of(String name, String explanation, int premium, Type type ){
        return Insurance.builder()
                .name(name)
                .explanation(explanation)
                .premium(premium)
                .authorization(true)
                .authorizationDate(LocalDateTime.now())
                .createdDate(LocalDateTime.now())
                .type(type)
                .build();
    }


}
