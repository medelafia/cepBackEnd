package com.med.accountservice.usersManagement.web;

import com.med.accountservice.usersManagement.dto.*;
import com.med.accountservice.usersManagement.entity.Account;
import com.med.accountservice.usersManagement.service.AccountService;
import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/accounts")
@CrossOrigin("http://localhost:5173")
public class AccountController {
    @Autowired
    private AccountService accountService ;
    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest loginRequest) {
        return accountService.login(loginRequest);
    }
    @PostMapping("/loginByEmail")
    public LoginResponse loginByEmail(@RequestParam String email) {
        return accountService.loginByEmail(email);
    }
     @PostMapping("/resetPasswordByEmail/{email}")
    public void resetPasswordByEmail(@PathVariable String email) {
        accountService.resetPasswordByEmail(email);
     }
     @PostMapping("/verifierResetSession/{id}")
    public int verifierResetSession(@PathVariable String id) {
        return 10 ;
     }
    @PostMapping("/changePassword")
    public void changePassword(@RequestBody PasswordRequest passwordRequest) {
        accountService.changePassword(passwordRequest);
    }
    @GetMapping("/requestVerifierEmail")
    public void requestVerifierEmail(@RequestParam int id) {
        accountService.sendVerificationEmailLink(id);
    }
    @GetMapping("/verifierEmail")
    public void verifierEmail(@RequestParam int id , @RequestParam String emailEncoded ) {
        accountService.verifierEmail(id , emailEncoded);
    }
    @PostMapping("/{id}/update")
    public Account updateAccountInfo(@RequestBody AccountUpdateRequest accountUpdateRequest , @PathVariable int id) {
        return accountService.updateAccountInfo(accountUpdateRequest) ;
    }
    @PostMapping("/register/provider")
    public void register(@RequestPart("logo") @Nullable MultipartFile logo , @RequestPart("provider") ProviderRequest provider) {
        accountService.register(logo , provider);
    }
    @PostMapping(value = "/register/costumer" )
    public void register(@RequestPart(value = "profile" , required = true ) @Nullable MultipartFile profile ,
                                  @RequestPart(value = "costumer", required = true ) CostumerRequest costumer) {
        accountService.register(profile , costumer) ;
    }
}
