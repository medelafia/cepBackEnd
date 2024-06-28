package com.med.reservationservice.exceptionsHandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.Timestamp;
import java.util.NoSuchElementException;

@ControllerAdvice
public class ExceptionHandling {
    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ErrorsDetails> noSuchElementExceptionHandling(NoSuchElementException noSuchElementException) {
        return new ResponseEntity<>(ErrorsDetails.builder()
                .message(noSuchElementException.getMessage())
                .httpStatus(HttpStatus.NOT_FOUND)
                .timestamp(new Timestamp(System.currentTimeMillis()))
                .build() , HttpStatus.NOT_FOUND) ;
    }
}
