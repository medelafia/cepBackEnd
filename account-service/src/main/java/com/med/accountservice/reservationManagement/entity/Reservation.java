package com.med.accountservice.reservationManagement.entity;


import com.med.accountservice.enums.ReservationStatus;
import com.med.accountservice.offersManagement.entity.Offer;
import com.med.accountservice.usersManagement.entity.Costumer;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

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
    @Enumerated(value = EnumType.STRING)
    private ReservationStatus reservationStatus ;
    private String paymentLink ;
    private long totalAmount ;
    private String title ;
    @ManyToOne
    private Costumer costumer ;
}
