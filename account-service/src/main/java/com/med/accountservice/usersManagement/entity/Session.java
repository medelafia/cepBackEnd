package com.med.accountservice.usersManagement.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@AllArgsConstructor @NoArgsConstructor @Getter @Setter @Builder
public class Session {
    @Id
    private String sessionId ;
    private String username ;
}
