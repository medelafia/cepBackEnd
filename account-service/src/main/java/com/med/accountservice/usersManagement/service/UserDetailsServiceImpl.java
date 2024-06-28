package com.med.accountservice.usersManagement.service;

import com.med.accountservice.exceptions.NoElementException;
import com.med.accountservice.usersManagement.entity.Account;
import com.med.accountservice.usersManagement.repository.AccountRepo;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    AccountRepo accountRepo ;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if(accountRepo.findByUsernameOrEmail(username , username).isPresent()) {
            Account account = accountRepo.findByUsernameOrEmail(username , username).get() ;
            List<GrantedAuthority> authorities =
                    List.of(account.getRole())
                            .stream()
                            .map(role -> new SimpleGrantedAuthority(role)).collect(Collectors.toList()); ;
            return new User(account.getUsername() , account.getPassword() , authorities) ;
        }else {
            throw new NoElementException("the account not found");
        }
    }
}
