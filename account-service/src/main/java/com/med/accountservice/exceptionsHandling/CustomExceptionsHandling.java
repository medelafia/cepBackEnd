package com.med.accountservice.exceptionsHandling;

import com.med.accountservice.exceptions.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.Instant;

@ControllerAdvice
@AllArgsConstructor
@NoArgsConstructor
public class CustomExceptionsHandling {
    Timestamp timestamp ;
    @ExceptionHandler(NoElementException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public @ResponseBody ExceptionDetails noAccountExceptionHandler(NoElementException accountException) {
        return new ExceptionDetails(accountException.getMessage()  , timestamp , HttpStatus.NOT_FOUND ) ;
    }
    @ExceptionHandler(ConflictException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public @ResponseBody ExceptionDetails conflictAccountExceptionHandling(ConflictException conflictException) {
        return new ExceptionDetails(conflictException.getMessage() ,timestamp , HttpStatus.CONFLICT) ;
    }
    @ExceptionHandler(PasswordIncorrectException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public @ResponseBody ExceptionDetails passwordIncorrectExceptionHandling(PasswordIncorrectException passwordIncorrectException) {
        return new ExceptionDetails(passwordIncorrectException.getMessage() , timestamp , HttpStatus.UNAUTHORIZED) ;
    }
    @ExceptionHandler(SessionExpiredException.class)
    @ResponseStatus(HttpStatus.REQUEST_TIMEOUT)
    public @ResponseBody ExceptionDetails sessionExpiredExceptionHandling(SessionExpiredException sessionExpiredException) {
        return new ExceptionDetails(sessionExpiredException.getMessage() , Timestamp.from(Instant.now()), HttpStatus.REQUEST_TIMEOUT) ;
    }
}
