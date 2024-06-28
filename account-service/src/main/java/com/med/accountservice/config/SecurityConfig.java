package com.med.accountservice.config;


import com.med.accountservice.config.filters.JwtFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf(csrf -> csrf.disable()) ;
        httpSecurity.sessionManagement(sm -> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) ;
        httpSecurity.authorizeHttpRequests(auth ->
                auth
                        .requestMatchers("/airlines/**").hasAuthority("PROVIDER_AIRLINE")
                        .requestMatchers("/carsAgencies/**").hasAuthority("PROVIDER_CARAGENCY")
                        .requestMatchers("/hotels/**").hasAuthority("PROVIDER_HOTEL")
                        .requestMatchers("/travelsAgencies/**").hasAuthority("PROVIDER_TRAVELAGENCY")
                        .requestMatchers("/railwaysOperators/**").hasAuthority("PROVIDER_RAILWAYOPERATOR")
                        .requestMatchers("/costumers/**").hasAuthority("COSTUMER")
                        .requestMatchers("/gates/**",
                                "/offer/**" ,
                                "/accounts/login/**" ).permitAll()
                        .anyRequest().authenticated());
        httpSecurity.addFilterBefore(new JwtFilter() , BasicAuthenticationFilter.class) ;
        return httpSecurity.build();
    }
}
