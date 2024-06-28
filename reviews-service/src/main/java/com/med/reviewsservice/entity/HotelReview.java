package com.med.reviewsservice.entity;

import com.med.reviewsservice.enums.RoomType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.sql.Date;

@Entity @AllArgsConstructor @NoArgsConstructor @SuperBuilder @Getter @Setter
public class HotelReview extends Review{
    private Date seatingDate ;
    private int nbOfDays ;
    @Enumerated(value = EnumType.STRING)
    private RoomType roomType ;
}
