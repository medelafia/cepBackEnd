package com.med.accountservice.mapper;

import com.med.accountservice.dto.AccountDto;
import com.med.accountservice.entity.Account;
import com.med.accountservice.enums.AccountType;

public class AccountMapper {
    public static Account toAccount(AccountDto accountDto ) {
        Account account = Account.builder()
                .username(accountDto.getUsername())
                .email(accountDto.getEmail())
                .tel(accountDto.getTel())
                .password(accountDto.getPassword())
                .accountType(accountDto.getAccountType().equalsIgnoreCase("costumer") ? AccountType.COSTUMER_ACCOUNT : AccountType.PROVIDER_ACCOUNT)
                .build();
        return account;
    }
    public static AccountDto toAccountDto(Account account ) {
        AccountDto accountDto = AccountDto.builder()
                .username(account.getUsername())
                .password(account.getPassword())
                .email(account.getEmail())
                .tel(account.getTel())
                .accountType(account.getAccountType() == AccountType.COSTUMER_ACCOUNT ? "costumer" : "provider")
                .build();
        return accountDto ;
    }
}
