package com.med.accountservice.exceptions;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor @Getter @Setter @Builder
public class SessionExpiredException extends RuntimeException{
    private String message ;
}
