package com.med.mailingservice.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor @NoArgsConstructor @Getter @Setter @SuperBuilder
public class SimpleEmailDetails {
    private String to;
    private String subject ;
    private String msg ;
}
