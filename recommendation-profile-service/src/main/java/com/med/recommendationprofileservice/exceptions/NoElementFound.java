package com.med.recommendationprofileservice.exceptions;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor @NoArgsConstructor
public class NoElementFound extends RuntimeException{
    String mess ;
}
