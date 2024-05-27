package com.med.recommendationprofileservice.excetionsHandling;

import com.med.recommendationprofileservice.exceptions.ErrorDetails;
import com.med.recommendationprofileservice.exceptions.NoElementFound;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.sql.Timestamp;

@ControllerAdvice
public class CustomExceptionHandling {
    @ExceptionHandler(NoElementFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorDetails noElementFoundHandler(NoElementFound noElementFound) {
        return new ErrorDetails(noElementFound.getMessage() , HttpStatus.NOT_FOUND , new Timestamp(System.currentTimeMillis())) ;
    }
}
