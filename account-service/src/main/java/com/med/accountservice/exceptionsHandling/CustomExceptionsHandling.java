package com.med.accountservice.exceptionsHandling;

import com.med.accountservice.exceptions.ExceptionDetails;
import com.med.accountservice.exceptions.NoAccountException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class CustomExceptionsHandling {
    @ExceptionHandler(NoAccountException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public @ResponseBody ExceptionDetails noAccountExceptionHandler(NoAccountException accountException) {
        return new ExceptionDetails("no account found") ;
    }
}
