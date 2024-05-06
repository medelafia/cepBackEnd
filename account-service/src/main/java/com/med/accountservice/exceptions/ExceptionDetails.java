package com.med.accountservice.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.http.HttpStatus;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class ExceptionDetails {
    private String message ;
}
