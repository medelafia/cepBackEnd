package com.med.accountservice.reviewsManagement.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.med.accountservice.usersManagement.entity.Costumer;
import com.med.accountservice.usersManagement.entity.Provider;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.sql.Date;

@Entity
@AllArgsConstructor @NoArgsConstructor @Getter @Setter @SuperBuilder
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;
    private String content ;
    private int score ;
    private Date date ;
    private String title ;
    @ManyToOne
    private Provider provider ;
    @OneToOne
    private Costumer costumer ;
    @Transient
    private String costumerFullName ;
}
