package com.med.accountservice.usersManagement.web;

import com.med.accountservice.usersManagement.dto.CostumerUpdateRequest;
import com.med.accountservice.usersManagement.dto.LoginRequest;
import com.med.accountservice.usersManagement.dto.PasswordRequest;
import com.med.accountservice.usersManagement.entity.Account;
import com.med.accountservice.usersManagement.entity.Costumer;
import com.med.accountservice.usersManagement.entity.Provider;
import com.med.accountservice.usersManagement.service.AccountService;
import com.med.accountservice.usersManagement.service.SessionService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/accounts")
@CrossOrigin("http://localhost:5173")
public class AccountController {
    @Autowired
    private AccountService accountService ;
    @PostMapping("/register/costumer/")
    public Costumer registreCostumer(@RequestBody Costumer costumer){
        return accountService.register(costumer);
    }
    @PostMapping("/register/provider/")
    public Provider registerProvider(@RequestBody Provider provider) {
        return accountService.register(provider) ;
    }
    @PostMapping("/login")
    public Account login(@RequestBody LoginRequest loginRequest) {
        return accountService.login(loginRequest) ;
    }
    @PostMapping("/loginByEmail")
    public Account loginByEmail(@RequestParam String email) {
        return accountService.loginByEmail(email);
    }
     @PostMapping("/resetPasswordByEmail/{email}")
    public void resetPasswordByEmail(@PathVariable String email) {
        accountService.resetPasswordByEmail(email);
     }
     @PostMapping("/verifierResetSession/{id}")
    public int verifierResetSession(@PathVariable String id) {
        return accountService.verifierResetSession(id) ;
     }
    @PostMapping("/changePassword")
    public void changePassword(@RequestBody PasswordRequest passwordRequest) {
        accountService.changePassword(passwordRequest);
    }
}
