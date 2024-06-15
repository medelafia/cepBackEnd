package com.med.accountservice.exceptionsHandling;

import com.med.accountservice.exceptions.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.Instant;

@ControllerAdvice
@AllArgsConstructor
@NoArgsConstructor
public class CustomExceptionsHandling {
    Timestamp timestamp ;
    @ExceptionHandler(NoElementException.class)
    public ResponseEntity<ExceptionDetails> noAccountExceptionHandler(NoElementException accountException) {
        ExceptionDetails exceptionDetails = new ExceptionDetails(accountException.getMessage()  , timestamp , HttpStatus.NOT_FOUND)  ;
        return new ResponseEntity(exceptionDetails,HttpStatus.NOT_FOUND) ;
    }
    @ExceptionHandler(ConflictException.class)
    public ResponseEntity<ExceptionDetails> conflictAccountExceptionHandling(ConflictException conflictException) {
        ExceptionDetails exceptionDetails =new ExceptionDetails(conflictException.getMessage() ,timestamp , HttpStatus.CONFLICT) ;
        return new ResponseEntity(exceptionDetails, HttpStatus.CONFLICT) ;
    }
    @ExceptionHandler(PasswordIncorrectException.class)
    public ResponseEntity<ExceptionDetails> passwordIncorrectExceptionHandling(PasswordIncorrectException passwordIncorrectException) {
        ExceptionDetails exceptionDetails = new ExceptionDetails(passwordIncorrectException.getMessage() , timestamp , HttpStatus.UNAUTHORIZED) ;
        return new ResponseEntity<>(exceptionDetails , HttpStatus.UNAUTHORIZED) ;
    }
    @ExceptionHandler(SessionExpiredException.class)
    @ResponseStatus(HttpStatus.REQUEST_TIMEOUT)
    public @ResponseBody ExceptionDetails sessionExpiredExceptionHandling(SessionExpiredException sessionExpiredException) {
        return new ExceptionDetails(sessionExpiredException.getMessage() , Timestamp.from(Instant.now()), HttpStatus.REQUEST_TIMEOUT) ;
    }
}
