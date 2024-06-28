package com.med.reservationservice.exceptionsHandling;

import lombok.*;
import org.springframework.http.HttpStatus;

import java.sql.Timestamp;

@AllArgsConstructor @NoArgsConstructor @Builder @Getter @Setter
public class ErrorsDetails {
    private String message ;
    private HttpStatus httpStatus ;
    private Timestamp timestamp ;
}
