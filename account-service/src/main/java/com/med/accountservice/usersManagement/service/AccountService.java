package com.med.accountservice.usersManagement.service;


import com.med.accountservice.exceptions.ConflictException;
import com.med.accountservice.exceptions.NoElementException;
import com.med.accountservice.exceptions.PasswordIncorrectException;
import com.med.accountservice.service.JwtService;
import com.med.accountservice.usersManagement.dto.*;
import com.med.accountservice.usersManagement.entity.Account;
import com.med.accountservice.usersManagement.entity.Costumer;
import com.med.accountservice.usersManagement.entity.Provider;
import com.med.accountservice.usersManagement.feignClient.MailingRepo;
import com.med.accountservice.usersManagement.model.SimpleEmailDetails;
import com.med.accountservice.usersManagement.repository.AccountRepo;
import com.med.accountservice.usersManagement.repository.CostumerRepo;
import com.med.accountservice.usersManagement.repository.ProviderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class AccountService {
    @Autowired
    private AccountRepo accountRepo ;
    @Autowired
    private CostumerRepo costumerRepo ;
    @Autowired
    private ProviderRepo providerRepo ;
    @Autowired
    private PasswordEncoder passwordEncoder ;
    @Autowired
    private MailingRepo mailingRepo ;
    @Autowired
    private UserDetailsServiceImpl userDetailsService ;
    @Autowired
    private JwtService jwtService ;
    public LoginResponse login(LoginRequest loginRequest){
        if(accountRepo.findByUsernameOrEmail(loginRequest.getUsername(), loginRequest.getUsername()).isPresent()) {
            Account account = accountRepo.findByUsernameOrEmail(loginRequest.getUsername(), loginRequest.getUsername()).get() ;
            if (passwordEncoder.matches(loginRequest.getPassword(), account.getPassword())) {
                UserDetails userDetails = userDetailsService.loadUserByUsername(loginRequest.getUsername()) ;
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                        new UsernamePasswordAuthenticationToken(userDetails , null , userDetails.getAuthorities()) ;
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
                String jwt = jwtService.generateJWT(usernamePasswordAuthenticationToken) ;
                return new LoginResponse(jwt , "");
            } else {
                throw new PasswordIncorrectException("the password is incorrect");
            }
        }else {
            throw new NoElementException("you are not registred ") ;
        }
    }
    public Account loginByEmail(String email) {
        if(accountRepo.findByEmail(email).isPresent()) {
            Account account = accountRepo.findByEmail(email).get() ;
            if(account.isRegisterByGoogle()) {
                return account ;
            }else {
                throw new NoElementException("your are not registered by google") ;
            }
        }else {
            throw new NoElementException("the account not found") ;
        }
    }
    public List<Costumer> getAllCostumers() {
        return costumerRepo.findAll() ;
    }
    public List<Provider> getAllProviders() {
        return providerRepo.findAll() ;
    }
    public void resetPasswordByEmail(String email) {
        Account account = accountRepo.findByEmail(email).orElseThrow(()->{
            throw new NoElementException("the account not found") ;
        }) ;
        if(account != null ) {
            String message = "to reset your password go to this url : http://localhost:5173/resetPassword/" ;
            mailingRepo.sendMail(new SimpleEmailDetails(account.getEmail() ,"reset password" ,  message));
        }
    }
    public void changePassword(PasswordRequest passwordRequest) {
        Account account = accountRepo.findByUsername(passwordRequest.getUsername()).orElseThrow(()->{
            throw new NoElementException("the account not found") ;
        }) ;
        if( account != null ) {
            if(passwordEncoder.matches(passwordRequest.getCurrentPassword() , account.getPassword())) {
                account.setPassword(passwordEncoder.encode(passwordRequest.getNewPassword()));
                accountRepo.save(account);
            }else {
                throw new PasswordIncorrectException("the password is incorrect") ;
            }
        }
    }
    public void sendVerificationEmailLink(int accountId) {
        Account account = accountRepo.findById(accountId).orElseThrow(()->{
            throw new NoElementException("the account not exist") ;
        }) ;
        mailingRepo.sendMail(new SimpleEmailDetails(account.getEmail() ,
                "verifier email" ,
                "to verifier your email please subscribe this link : http://localhost:8089/accounts/verifierEmail?emailEncoded="+passwordEncoder.encode(account.getEmail())+"&userId="+accountId)) ;
    }
    public void verifierEmail(int accountId , String emailEncoded) {
        Account account = accountRepo.findById(accountId).orElseThrow(()->{
            throw new NoElementException("account not found");
        }) ;
        if(account != null ) {
            if(passwordEncoder.matches(account.getEmail() , emailEncoded)) {
                account.verifyEmail();
                accountRepo.save(account) ;
            }else {
                throw new NoElementException("the account not found") ;
            }
        }
    }


    public Account updateAccountInfo(int id , AccountUpdateRequest accountUpdateRequest) {
        if (accountRepo.findById(id).isPresent()) {
            Account account = accountRepo.findById(id).get() ;
            if(account.getUsername() == accountUpdateRequest.getUsername()) {
                if(account.getEmail() != accountUpdateRequest.getEmail()) {
                    if(accountRepo.findByEmail(accountUpdateRequest.getEmail()).isPresent()) {
                        throw new ConflictException("the email is used , try another one") ;
                    }else {
                        account.setEmail(accountUpdateRequest.getEmail());
                        account.setTel(accountUpdateRequest.getTel()) ;
                    }
                }
            }else {
                if(accountRepo.findByUsername(accountUpdateRequest.getUsername()).isPresent()) {
                    throw new ConflictException("the username is used , try another one") ;
                }else {
                    account.setUsername(accountUpdateRequest.getUsername());
                    if(account.getEmail() != accountUpdateRequest.getEmail()) {
                        if(accountRepo.findByEmail(accountUpdateRequest.getEmail()).isPresent()) {
                            throw new ConflictException("the email is used , try another one") ;
                        }else {
                            account.setEmail(accountUpdateRequest.getEmail());
                            account.setTel(accountUpdateRequest.getTel()) ;
                        }
                    }
                }
            }

            return accountRepo.save(account) ;
        }else {
            throw new NoElementException("the account not found") ;
        }
    }
}
