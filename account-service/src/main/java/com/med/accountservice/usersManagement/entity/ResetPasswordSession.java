package com.med.accountservice.usersManagement.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.sql.Timestamp;
import java.time.Instant;

@Entity
@AllArgsConstructor @NoArgsConstructor @Getter @Setter @Builder
public class ResetPasswordSession {
    @Id
    private String id ;
    private int userId ;
    private Instant expiredAt ;
}
