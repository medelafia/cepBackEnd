package com.med.accountservice.recommendationProfileManagement.exceptions;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor @NoArgsConstructor
public class NoElementFound extends RuntimeException{
    String mess ;
}
