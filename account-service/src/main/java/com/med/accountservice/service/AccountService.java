package com.med.accountservice.service;

import com.med.accountservice.entity.Account;
import com.med.accountservice.model.LoginRequest;
import com.med.accountservice.repository.AccountRepository;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    AccountRepository accountRepository ;
    public AccountService(AccountRepository accountRepository ) {
        this.accountRepository = accountRepository ;
    }
    public Account login(LoginRequest loginRequest) {
        String username = loginRequest.getUsername() ;
        String password = loginRequest.getPassword() ;
        Account account = accountRepository.findByUsername(username).get();
        if(account != null){
            if(account.getPassword().equals(password)) {
                return account ;
            }
        }
        return null ;
    }
}
