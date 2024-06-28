package com.med.accountservice.usersManagement.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.antlr.v4.runtime.misc.NotNull;

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Entity
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@SuperBuilder
@ToString
public abstract class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;
    @NotNull
    @Column(unique = true)
    private String username ;
    private String password ;
    private String role ;
    @NotNull
    @Column(unique = true)
    private String email ;
    private String tel ;
    private boolean emailVerified ;
    private boolean registerByGoogle ;
    private boolean registerByFacebook ;
    private String country ;
    private String address ;
    public abstract Account login(String username , String password) ;
    public abstract Account register(Account account ) ;
    public void verifyEmail() {
        this.emailVerified = true ;
    }
}
