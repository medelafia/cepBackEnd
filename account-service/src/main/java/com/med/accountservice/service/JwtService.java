package com.med.accountservice.service;

import com.med.accountservice.usersManagement.entity.Account;
import com.med.accountservice.usersManagement.repository.AccountRepo;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cglib.core.Local;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service ;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;

@Service
public class JwtService {
    @Autowired
    AccountRepo accountRepo ;
    public String generateJWT(Authentication authentication) {
        Collection<? extends  GrantedAuthority> authorities = authentication.getAuthorities() ;
        HashSet<String> set = new HashSet<>( );
        for(GrantedAuthority authority : authorities){
            set.add(authority.getAuthority()) ;
        }
        String roles = String.join("," , set) ;
        Account account = accountRepo.findByUsernameOrEmail(authentication.getName() , authentication.getName()).get() ;
        JwtBuilder jwtBuilder = Jwts.builder()
                .claim("username" , authentication.getName())
                .claim("authority" , roles)
                .claim("email" , account.getEmail() )
                .claim("emailVerified" , account.isEmailVerified())
                .claim("tel" , account.getTel())
                .claim("address" , account.getAddress())
                .claim("country" , account.getCountry())
                .claim("registeredByGoogle" , account.isRegisterByGoogle())
                .claim("id" , account.getId() )
                .setIssuedAt(Date.from(Instant.now()))
                .setExpiration(Date.from(Instant.now().plus(2 , ChronoUnit.DAYS )))
                .signWith(SignatureAlgorithm.HS256 , JwtConstant.secret ) ;
        String jwt = jwtBuilder.compact() ;
        return jwt  ;
    }
}
