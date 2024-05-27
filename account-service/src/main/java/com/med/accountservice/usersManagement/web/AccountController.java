package com.med.accountservice.usersManagement.web;

import com.med.accountservice.usersManagement.dto.LoginRequest;
import com.med.accountservice.usersManagement.entity.Account;
import com.med.accountservice.usersManagement.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/accounts")
@AllArgsConstructor
public class AccountController {
    private AccountService accountService ;
    @GetMapping("/")
    public List<Account> getAllAccounts() {
        return accountService.getAllAccounts() ;
    }
    @PostMapping("/registre")
    public Account registre(Account account) {
        return accountService.register(account) ;
    }
    @PostMapping("/login")
    public Account login(LoginRequest loginRequest) {
        return accountService.login(loginRequest) ;
    }
    @PostMapping("/update")
    public Account updateAccountInfo(Account account) {
        return accountService.updateAccountInfo(account);
    }
}
