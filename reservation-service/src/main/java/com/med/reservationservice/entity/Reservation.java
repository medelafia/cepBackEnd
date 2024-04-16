package com.med.reservationservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.med.reservationservice.enums.ReservationStatus;
import com.med.reservationservice.model.Client;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.internal.build.AllowNonPortable;

import java.util.Date;

@MappedSuperclass
@AllArgsConstructor @NoArgsConstructor @SuperBuilder
@Getter @Setter
public class Reservation {
    @Id
    private int id ;
    private int nbPersons ;
    private long price ;
    private boolean isPaid ;
    private Date reservationDate ;
    @JsonIgnore
    private int clientId ;
    @Transient
    private Client client ;
    @Enumerated(value = EnumType.STRING)
    private ReservationStatus reservationStatus ;
}
