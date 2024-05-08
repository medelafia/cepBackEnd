package com.med.accountservice.exceptions;

public class ConflictException extends RuntimeException{
    public ConflictException(String msg) {
        super(msg);
    }
}
