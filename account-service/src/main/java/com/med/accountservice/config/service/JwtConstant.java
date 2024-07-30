package com.med.accountservice.config.service;

import io.jsonwebtoken.Jwts;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;

import java.security.Key;

public class JwtConstant {
    public static Key secret = Jwts.SIG.HS256.key().build();
}
