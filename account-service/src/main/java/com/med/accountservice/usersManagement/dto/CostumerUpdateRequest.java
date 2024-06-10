package com.med.accountservice.usersManagement.dto;

import lombok.*;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder
public class CostumerUpdateRequest {
    private String firstName ;
    private String lastName ;
    private String gender ;
    private int age ;
}
