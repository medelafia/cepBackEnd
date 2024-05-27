package com.med.accountservice.usersManagement.service;

import com.med.accountservice.exceptions.NoElementException;
import com.med.accountservice.exceptions.PasswordIncorrectException;
import com.med.accountservice.usersManagement.dto.LoginRequest;
import com.med.accountservice.usersManagement.entity.Account;
import com.med.accountservice.usersManagement.repository.AccountRepo;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class AccountService {
    private AccountRepo accountRepo ;
    @Transactional
    public Account register(Account account) {
        return accountRepo.save(account) ;
    }
    public Account login(LoginRequest loginRequest) {
        Account account = accountRepo.findByUsername(loginRequest.getUsername()).orElseThrow(()->{
            throw new NoElementException("account not exist") ;
        }) ;
        if(account != null) {
            if(account.getPassword().equals(loginRequest.getPassword())){
                return account ;
            }else {
                throw new PasswordIncorrectException("password incorrect") ;
            }
        }
        return null ;
    }
    public List<Account> getAllAccounts() {
        return accountRepo.findAll();
    }
    @Transactional
    public Account updateAccountInfo(Account account) {
        return accountRepo.save(account) ;
    }
}
