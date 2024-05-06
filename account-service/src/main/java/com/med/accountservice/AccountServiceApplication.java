package com.med.accountservice;

import com.med.accountservice.entity.Account;
import com.med.accountservice.enums.AccountType;
import com.med.accountservice.repository.AccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AccountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountServiceApplication.class, args);
    }
    //@Bean
    CommandLineRunner lineRunner(AccountRepository accountRepository) {
        return args -> {
             accountRepository.save(Account.builder()
                             .username("mohamed")
                             .password("med@29072003")
                             .email("mohamedelafia016@gmail.com")
                             .tel("0658045721")
                             .accountType(AccountType.COSTUMER_ACCOUNT)
                     .build()) ;
        } ;
    }
}
