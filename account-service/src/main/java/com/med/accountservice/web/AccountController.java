package com.med.accountservice.web;

import com.med.accountservice.entity.Account;
import com.med.accountservice.model.LoginRequest;
import com.med.accountservice.service.AccountService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts")
@CrossOrigin("http://localhost:5173")
public class AccountController {
    AccountService accountService ;
    public AccountController(AccountService accountService) {
        this.accountService = accountService ;
    }
    @PostMapping("/register")
    public void register() {

    }
    @PostMapping("/login")
    public Account login(@RequestBody LoginRequest loginRequest) {
        return accountService.login(loginRequest);
    }
}
