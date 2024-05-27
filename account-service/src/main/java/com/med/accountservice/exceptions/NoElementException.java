package com.med.accountservice.exceptions;

import lombok.*;

public class NoElementException extends RuntimeException{
    private String message ;
    public NoElementException(String message) {
        super(message);
    }
}
