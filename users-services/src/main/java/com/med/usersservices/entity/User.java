package com.med.usersservices.entity;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@MappedSuperclass
@Getter @Setter
@SuperBuilder
@AllArgsConstructor @NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;
    private String username ;
    private String password ;
    private String authority ;
    private String email ;
    private String tel ;
    public User(String username , String password , String authority , String email , String tel ) {
        this.username = username ;
        this.password = password ;
        this.authority = authority ;
        this.email = email ;
        this.tel = tel ;
    }
}
