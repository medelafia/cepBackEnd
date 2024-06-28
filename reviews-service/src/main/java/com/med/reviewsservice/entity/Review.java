package com.med.reviewsservice.entity;

import com.med.reviewsservice.enums.ReviewFor;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.sql.Date;

@MappedSuperclass
@AllArgsConstructor @NoArgsConstructor @Getter @Setter @SuperBuilder
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;
    private String content ;
    private int score ;
    private Date date ;
    private String title ;
    private int providerId ;
    private int clientId ;

}
