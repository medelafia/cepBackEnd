package com.med.accountservice.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.sql.Timestamp;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class ExceptionDetails {
    private String message ;
    private Timestamp timestamp ;
    private HttpStatus httpStatus ;
}
