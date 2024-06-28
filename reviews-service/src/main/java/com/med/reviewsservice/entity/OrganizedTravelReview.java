package com.med.reviewsservice.entity;

import com.med.reviewsservice.enums.SeatType;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity @AllArgsConstructor @NoArgsConstructor @Getter @Setter @SuperBuilder
public class OrganizedTravelReview extends TravelReview{
    private int numberOfDays ;
    private int nbOfStops ;
}
