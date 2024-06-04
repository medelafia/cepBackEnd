package com.med.accountservice.usersManagement.service;

import com.med.accountservice.exceptions.NoElementException;
import com.med.accountservice.usersManagement.entity.Account;
import com.med.accountservice.usersManagement.entity.Session;
import com.med.accountservice.usersManagement.repository.AccountRepo;
import com.med.accountservice.usersManagement.repository.SessionRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class SessionService {
    private SessionRepo sessionRepo ;
    private AccountRepo accountRepo ;
    public Account login(String sessionId) {
        Session session = sessionRepo.findById(sessionId).orElseThrow(()->{
            throw new NoElementException("the session not found") ;
        });
        if(session != null) {
            Account account = accountRepo.findByUsername(session.getUsername()).orElseThrow(()->{
                throw new NoElementException("account not found") ;
            }) ;
            return account ;
        }
        return null  ;
    }
    public Session createLoginSession(String username) {
        Session session = Session.builder()
                .sessionId(UUID.randomUUID().toString())
                .username(username)
                .build() ;
        return session ;
    }
}
