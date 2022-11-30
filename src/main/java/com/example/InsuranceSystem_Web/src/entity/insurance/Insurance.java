package com.example.InsuranceSystem_Web.src.entity.insurance;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.SQLDelete;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "iType")
@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
@SQLDelete(sql = "DELETE from insurance WHERE insurance_id = ?")
public abstract class Insurance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "insurance_id")
    private Long id;

    private String name;
    private String explanation;
    private int premium;

    public boolean authorization;
    private LocalDateTime authorizationDate;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    public Insurance(String name, String explanation, int premium, LocalDateTime createdDate) {
        this.name = name;
        this.explanation = explanation;
        this.premium = premium;
        this.createdDate = createdDate;
    }
}
