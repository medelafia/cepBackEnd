package com.med.accountservice.exceptions;

import lombok.*;

@Getter
@Setter @AllArgsConstructor @NoArgsConstructor
public class NoAccountException extends RuntimeException{
    private String message ;
}
