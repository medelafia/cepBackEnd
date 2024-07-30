package com.med.accountservice.usersManagement.mapper;

import com.med.accountservice.usersManagement.entity.Account;
import com.med.accountservice.usersManagement.entity.Provider;

public class AccountMapper {
    public static Provider toProvider(Account account) {
        return Provider.builder()
                .username(account.getUsername())
                .password(account.getPassword())
                .role(account.getRole())
                .email(account.getEmail())
                .registerByGoogle(account.isRegisterByGoogle())
                .emailVerified(account.isEmailVerified())
                .build() ;
    }
}
