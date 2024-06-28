package com.med.reviewsservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.sql.Date;

@MappedSuperclass
@AllArgsConstructor @NoArgsConstructor @Getter @Setter @SuperBuilder
public class TravelReview extends Review{
    private String origin ;
    private String destination ;
    private Date travelDate ;
}
