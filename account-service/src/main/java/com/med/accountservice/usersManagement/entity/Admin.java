package com.med.accountservice.usersManagement.entity;


import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
public class Admin extends Account{
    @Override
    public Account login(String username, String password) {
        return null;
    }
    @Override
    public Account register(Account account) {
        return null;
    }
}
