package com.med.accountservice.messagesManagement.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.sql.Date;

@Entity @AllArgsConstructor @NoArgsConstructor @Getter @Setter @Builder
public class Message {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int id ;
    private String content ;
    private String email ;
    private Date date ;
    private boolean unRead ;
}
