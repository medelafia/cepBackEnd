package com.med.accountservice.usersManagement.service;


import com.med.accountservice.exceptions.NoElementException;
import com.med.accountservice.exceptions.PasswordIncorrectException;
import com.med.accountservice.usersManagement.dto.CostumerUpdateRequest;
import com.med.accountservice.usersManagement.dto.LoginRequest;
import com.med.accountservice.usersManagement.dto.PasswordRequest;
import com.med.accountservice.usersManagement.entity.Account;
import com.med.accountservice.usersManagement.entity.Costumer;
import com.med.accountservice.usersManagement.entity.Provider;
import com.med.accountservice.usersManagement.entity.ResetPasswordSession;
import com.med.accountservice.usersManagement.feignClient.MailingRepo;
import com.med.accountservice.usersManagement.model.SimpleEmailDetails;
import com.med.accountservice.usersManagement.repository.AccountRepo;
import com.med.accountservice.usersManagement.repository.CostumerRepo;
import com.med.accountservice.usersManagement.repository.ProviderRepo;
import com.med.accountservice.usersManagement.repository.ResetPasswordSessionRepository;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.catalina.LifecycleState;
import org.bouncycastle.math.ec.rfc8032.Ed448;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
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
    private ResetPasswordSessionRepository resetPasswordSessionRepository ;
    @Autowired
    private MailingRepo mailingRepo ;
    public Costumer register(Costumer costumer) {
        costumer.setPassword(passwordEncoder.encode(costumer.getPassword()));
        return costumerRepo.save(costumer) ;
    }
    public Provider register(Provider provider) {
        provider.setPassword(passwordEncoder.encode(provider.getPassword()));
        return providerRepo.save(provider) ;
    }
    public Account login(LoginRequest loginRequest){
        Account account = accountRepo.findByUsername(loginRequest.getUsername()).orElseThrow(()->{
            throw new NoElementException("account not found") ;
        }) ;
        if(passwordEncoder.matches(loginRequest.getPassword() , account.getPassword())) {
            return account ;
        }else {
            throw new PasswordIncorrectException("the password is incorrect") ;
        }
    }
    public Account loginByEmail(String email) {
        Account account = accountRepo.findByEmail(email).orElseThrow(()->{
            throw new NoElementException("the account not found ") ;
        }) ;
        if(account.isRegisterByGoogle()){
            return account ;
        }else {
         throw new NoElementException("account not found") ;
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
            ResetPasswordSession resetPasswordSession = ResetPasswordSession.builder()
                    .id(UUID.randomUUID().toString())
                    .expiredAt(Instant.now().minusSeconds(120))
                    .userId(account.getId())
                    .build() ;
            resetPasswordSessionRepository.save(resetPasswordSession) ;
            String message = "to reset your password go to this url : http://localhost:5173/resetPassword/" +resetPasswordSession.getId() ;
            mailingRepo.sendMail(new SimpleEmailDetails(account.getEmail() ,"reset password" ,  message));
        }
    }
    public int verifierResetSession(String id) {
        ResetPasswordSession resetPasswordSession = resetPasswordSessionRepository.findById(id).orElseThrow(()->{
            throw new NoElementException("the session not found") ;
        }) ;
        if(resetPasswordSession != null ) {
            if( resetPasswordSession.getExpiredAt().isBefore(Instant.now())){
                return resetPasswordSession.getUserId() ;
            }
        }
        return -1 ;
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
    public Costumer updateInfo(int userId , CostumerUpdateRequest costumerUpdateRequest) {
        Costumer costumer = costumerRepo.findById(userId).orElseThrow(()->{
            throw new NoElementException("the account not found") ;
        }) ;
        if( costumer != null ){
            costumer.setAge(costumerUpdateRequest.getAge());
            costumer.setGender(costumerUpdateRequest.getGender());
            costumer.setFirstName(costumerUpdateRequest.getFirstName());
            costumer.setLastName(costumerUpdateRequest.getLastName());
            return costumerRepo.save(costumer) ;
        }
        return null  ;
    }

    public void setRecommendationActivation(int id , boolean newStat) {
        Costumer costumer = costumerRepo.findById(id).orElseThrow(()->{
            throw new NoElementException("account not found") ;
        }) ;
        costumer.setRecommendationProfileActivation(newStat);
        costumerRepo.save(costumer) ;
    }
}
