package com.med.accountservice.usersManagement.web;

import com.med.accountservice.usersManagement.dto.GRegistrationRequest;
import com.med.accountservice.usersManagement.dto.LoginRequest;
import com.med.accountservice.usersManagement.dto.PasswordRequest;
import com.med.accountservice.usersManagement.entity.Account;
import com.med.accountservice.usersManagement.service.AccountService;
import com.med.accountservice.usersManagement.service.SessionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/accounts")
@AllArgsConstructor
@CrossOrigin("http://localhost:5173")
public class AccountController {
    private AccountService accountService ;
    private SessionService sessionService ;
    @GetMapping("/")
    public List<Account> getAllAccounts() {
        return accountService.getAllAccounts() ;
    }
    @PostMapping("/registre")
    public Account registre(Account account) {
        return accountService.register(account) ;
    }
    @PostMapping("/login")
    public Account login(@RequestBody LoginRequest loginRequest) {
        return accountService.login(loginRequest) ;
    }
    @PostMapping("/update")
    public Account updateAccountInfo(Account account) {
        return accountService.updateAccountInfo(account);
    }
    @PostMapping("/changePassword")
    public void changePassword(PasswordRequest passwordRequest) {

    }
    @PostMapping("/loginBySessionId")
    public Account login(String sessionId) {
        return sessionService.login(sessionId) ;
    }
    @PostMapping("/loginByGoogle")
    public Account loginByGoogle(String email) {
        return accountService.loginByGoogle(email) ;
    }
    @PostMapping("/registreByGoogleAccount")
    public Account registreByGoogleAccount(GRegistrationRequest googleRegistrationRequest) {
        return accountService.registerByGoogleAccount(googleRegistrationRequest);
    }
}
