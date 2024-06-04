package com.med.accountservice.usersManagement.service;

import com.med.accountservice.exceptions.NoElementException;
import com.med.accountservice.exceptions.PasswordIncorrectException;
import com.med.accountservice.imagesManagement.entity.Image;
import com.med.accountservice.imagesManagement.service.ImageService;
import com.med.accountservice.usersManagement.dto.LoginRequest;
import com.med.accountservice.usersManagement.entity.Account;
import com.med.accountservice.usersManagement.repository.AccountRepo;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.med.accountservice.usersManagement.dto.GRegistrationRequest ;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AccountService {
    private AccountRepo accountRepo ;
    private PasswordEncoder passwordEncoder ;
    private ImageService imageService ;
    public AccountService(AccountRepo accountRepo , PasswordEncoder passwordEncoder , ImageService imageService) {
        this.accountRepo = accountRepo ;
        this.passwordEncoder = passwordEncoder ;
        this.imageService = imageService ;
    }
    @Transactional
    public Account register(Account account) {
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        return accountRepo.save(account) ;
    }
    public Account login(LoginRequest loginRequest) {
        Account account = accountRepo.findByUsername(loginRequest.getUsername()).orElseThrow(()-> new NoElementException("account not exist")) ;
        if(account != null) {
            if(passwordEncoder.matches(loginRequest.getPassword() , account.getPassword())){
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

    public Account loginByGoogle(String email) {
        Account account = accountRepo.findByEmail(email).orElseThrow(()->{
            throw new NoElementException("account not found") ;
        }) ;
        if(account != null ){
            return account ;
        }
        return null ;
    }
    public Account registerByGoogleAccount(GRegistrationRequest googleRegistrationRequest) {
        Image image = imageService.saveImage(googleRegistrationRequest.getImageProfileUrl()) ;
        return Account.builder().build() ;
    }
    public String generateJwt() {

        return "" ;
    }
}
