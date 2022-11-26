package com.example.InsuranceSystem_Web.src.entity.insurance;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "iType")
@SuperBuilder @NoArgsConstructor
@Getter
public class Insurance {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "insurance_id")
    private Long id;

    private String name;
    private String explanation;
    private int premium;

    public boolean authorization;
    private LocalDateTime authorizationDate;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;


    public Insurance(String name, String explanation, int premium,
                     boolean authorization, LocalDateTime authorizationDate,
                     LocalDateTime createdDate, LocalDateTime modifiedDate) {
        this.name = name;
        this.explanation = explanation;
        this.premium = premium;
        this.authorization = authorization;
        this.authorizationDate = authorizationDate;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }




}
