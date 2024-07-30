package com.med.accountservice.usersManagement.entity;


import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@SuperBuilder
@NoArgsConstructor
public class Admin extends Account{
    private int level ;
    @Override
    public Account login(String username, String password) {
        return null;
    }
    @Override
    public Account register(Account account) {
        return null;
    }
}
