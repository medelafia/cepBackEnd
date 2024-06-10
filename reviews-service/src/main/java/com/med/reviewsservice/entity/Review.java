package com.med.reviewsservice.entity;

import com.med.reviewsservice.enums.ReviewFor;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;

@Entity
@AllArgsConstructor @NoArgsConstructor @Getter @Setter @Builder
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;
    private String content ;
    private int score ;
    private Date date ;
    private String title ;
    private int providerId ;
}
