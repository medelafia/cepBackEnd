package com.med.accountservice.recommendationProfileManagement.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.sql.Timestamp;

@AllArgsConstructor @NoArgsConstructor @Getter @Setter
public class ErrorDetails {
    private String message ;
    private HttpStatus status ;
    private Timestamp timestamp ;
}
