package com.med.reservationservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.med.reservationservice.enums.ReservationStatus;
import com.med.reservationservice.model.Client;
import com.med.reservationservice.model.Offer;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.internal.build.AllowNonPortable;

import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@AllArgsConstructor @NoArgsConstructor @SuperBuilder
@Getter @Setter
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int id ;
    private boolean isPaid ;
    private Date reservationDate ;
    private int clientId ;
    private int offerId ;
    @Enumerated(value = EnumType.STRING)
    private ReservationStatus reservationStatus ;
    private String paymentLink ;
    private long totalAmount ;
    private String title ;
    @Transient
    private Offer offer ;
}
