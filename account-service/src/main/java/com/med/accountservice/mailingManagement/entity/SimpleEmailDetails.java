package com.med.accountservice.mailingManagement.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor @NoArgsConstructor @Getter @Setter @SuperBuilder
public class SimpleEmailDetails {
    private String to;
    private String subject ;
    private String msg ;
}
