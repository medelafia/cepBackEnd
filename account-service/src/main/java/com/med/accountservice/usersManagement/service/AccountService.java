package com.med.accountservice.usersManagement.service;


import com.med.accountservice.exceptions.ConflictException;
import com.med.accountservice.exceptions.NoElementException;
import com.med.accountservice.exceptions.PasswordIncorrectException;
import com.med.accountservice.imagesManagement.entity.Image;
import com.med.accountservice.imagesManagement.service.ImageService;
import com.med.accountservice.config.service.JwtService;
import com.med.accountservice.mailingManagement.service.MailingService;
import com.med.accountservice.usersManagement.dto.*;
import com.med.accountservice.usersManagement.entity.*;
import com.med.accountservice.mailingManagement.entity.SimpleEmailDetails;
import com.med.accountservice.usersManagement.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class AccountService {
    @Autowired
    private AccountRepo accountRepo ;
    @Autowired
    private CostumerRepo costumerRepo ;
    @Autowired
    private ProviderRepo providerRepo ;
    @Autowired
    private PasswordEncoder passwordEncoder ;
    @Autowired
    private MailingService mailingService ;
    @Autowired
    private UserDetailsServiceImpl userDetailsService ;
    @Autowired
    private JwtService jwtService ;
    @Autowired
    private ImageService imageService ;
    @Autowired
    AirlineRepo airlineRepo ;
    @Autowired
    HotelRepo hotelRepo ;
    @Autowired
    RailwayOperatorRepo railwayOperatorRepo ;
    @Autowired
    TravelAgencyRepo travelAgencyRepo ;
    @Autowired
    CarsAgencyRepo carsAgencyRepo ;
    @Autowired
    AdminRepo adminRepo ;
    public Account getAuthenticated() {
        return accountRepo.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName()).get();
    }
    public void checkMetaData(String username , String email ) {
        if(accountRepo.findByEmail(email).isPresent()) throw new ConflictException("you are registered") ;
        if(accountRepo.findByUsername(username).isPresent()) throw new ConflictException("the username already used") ;
    }
    public void register(Admin admin) {
        admin.setPassword(passwordEncoder.encode(admin.getPassword()));
        admin.setRole("ADMIN");
        adminRepo.save(admin) ;
    }
    public void register(MultipartFile profile, CostumerRequest costumerRequest) {
        this.checkMetaData(costumerRequest.getUsername() , costumerRequest.getEmail());
        Image image = null ;
        if( profile != null ){
            image = imageService.updloadImage(profile) ;
        }
        Costumer costumer = Costumer.builder()
                .username(costumerRequest.getUsername())
                .password(costumerRequest.isRegisterByGoogle() ? null : passwordEncoder.encode(costumerRequest.getPassword()))
                .email(costumerRequest.getEmail())
                .emailVerified(costumerRequest.isEmailVerified())
                .firstName(costumerRequest.getFirstName())
                .lastName(costumerRequest.getLastName())
                .age(costumerRequest.getAge())
                .gender(costumerRequest.getGender())
                .profileImage(image)
                .recommendationProfileActivation(true)
                .registerByGoogle(costumerRequest.isRegisterByGoogle())
                .role("COSTUMER")
                .build() ;
        costumer = costumerRepo.save(costumer) ;
    }
    public void register(MultipartFile logo , ProviderRequest providerRequest) {
        this.checkMetaData(providerRequest.getUsername() , providerRequest.getEmail());
        Image image = null ;
        if(logo != null) imageService.updloadImage(logo) ;
        Provider provider = Provider.builder()
                .username(providerRequest.getUsername())
                .password(providerRequest.isRegisterByGoogle() ? null : passwordEncoder.encode(providerRequest.getPassword()))
                .email(providerRequest.getEmail())
                .address(providerRequest.getAddress())
                .country(providerRequest.getCountry())
                .emailVerified(providerRequest.isEmailVerified())
                .registerByGoogle(providerRequest.isRegisterByGoogle())
                .webSiteUrl(providerRequest.getWebSiteUrl())
                .name(providerRequest.getName())
                .fax(providerRequest.getFax())
                .logo(image)
                .role("PROVIDER_" + String.join("" , providerRequest.getProviderType().toString().split("_"))).build();
        switch(providerRequest.getProviderType()) {
            case HOTEL -> provider = hotelRepo.save(new Hotel(provider)) ;
            case AIRLINE -> provider = airlineRepo.save(new Airline(provider)) ;
            case CAR_AGENCY -> provider = carsAgencyRepo.save(new CarsAgency(provider)) ;
            case RAILWAY_OPERATOR ->  provider = railwayOperatorRepo.save(new RailwayOperator(provider)) ;
            case TRAVEL_AGENCY -> provider = travelAgencyRepo.save(new TravelAgency(provider)) ;
        }
    }
    public LoginResponse login(LoginRequest loginRequest){
        if(accountRepo.findByUsernameOrEmail(loginRequest.getUsername(), loginRequest.getUsername()).isPresent()) {
            Account account = accountRepo.findByUsernameOrEmail(loginRequest.getUsername(), loginRequest.getUsername()).get() ;
            if(account.isRegisterByGoogle()) {
                UserDetails userDetails = userDetailsService.loadUserByUsername(loginRequest.getUsername()) ;
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                        new UsernamePasswordAuthenticationToken(userDetails , null , userDetails.getAuthorities()) ;
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
                String jwt = jwtService.generateJWT(usernamePasswordAuthenticationToken) ;
                return new LoginResponse(jwt , "");
            }else {
                if (passwordEncoder.matches(loginRequest.getPassword() , account.getPassword())) {
                    UserDetails userDetails = userDetailsService.loadUserByUsername(loginRequest.getUsername()) ;
                    UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                            new UsernamePasswordAuthenticationToken(userDetails , null , userDetails.getAuthorities()) ;
                    SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
                    String jwt = jwtService.generateJWT(usernamePasswordAuthenticationToken) ;
                    return new LoginResponse(jwt , "");
                } else {
                    throw new PasswordIncorrectException("the password is incorrect");
                }
            }
        }else {
            throw new NoElementException("you are not registered ") ;
        }
    }
    public LoginResponse loginByEmail(String email) {
        return this.login(new LoginRequest(email , "password")) ;
    }
    public void resetPasswordByEmail(String email) {
        Account account = accountRepo.findByEmail(email).orElseThrow(()->{
            throw new NoElementException("the account not found") ;
        }) ;
        if(account != null ) {
            String message = "to reset your password go to this url : http://localhost:5173/resetPassword/" ;
            mailingService.sendSimpleMail(new SimpleEmailDetails(account.getEmail() ,"reset password" ,  message));
        }
    }
    public void changePassword(PasswordRequest passwordRequest) {
        Account account = accountRepo.findByUsername(passwordRequest.getUsername()).orElseThrow(()->{
            throw new NoElementException("the account not found") ;
        }) ;
        if( account != null ) {
            if(passwordEncoder.matches(passwordRequest.getCurrentPassword() , account.getPassword())) {
                account.setPassword(passwordEncoder.encode(passwordRequest.getNewPassword()));
                accountRepo.save(account);
            }else {
                throw new PasswordIncorrectException("the password is incorrect") ;
            }
        }
    }
    public void sendVerificationEmailLink(int accountId) {
        Account account = accountRepo.findById(accountId).orElseThrow(()->{
            throw new NoElementException("the account not exist") ;
        }) ;
        mailingService.sendSimpleMail(new SimpleEmailDetails(account.getEmail() ,
                "verifier email" ,
                "to verifier your email please subscribe this link : http://localhost:8089/accounts/verifierEmail?emailEncoded="+passwordEncoder.encode(account.getEmail())+"&userId="+accountId)); ;
    }
    public void verifierEmail(int accountId , String emailEncoded) {
        Account account = accountRepo.findById(accountId).orElseThrow(()->{
            throw new NoElementException("account not found");
        }) ;
        if(account != null ) {
            if(passwordEncoder.matches(account.getEmail() , emailEncoded)) {
                account.verifyEmail();
                accountRepo.save(account) ;
            }else {
                throw new NoElementException("the account not found") ;
            }
        }
    }


    public Account updateAccountInfo(AccountUpdateRequest accountUpdateRequest) {
        Account account = this.getAuthenticated() ;
        if(account.getUsername() == accountUpdateRequest.getUsername()) {
            if(account.getEmail() != accountUpdateRequest.getEmail()) {
                if(accountRepo.findByEmail(accountUpdateRequest.getEmail()).isPresent()) {
                    throw new ConflictException("the email is used , try another one") ;
                }else {
                    account.setEmail(accountUpdateRequest.getEmail());
                }
            }
        }else {
            if(accountRepo.findByUsername(accountUpdateRequest.getUsername()).isPresent()) {
                throw new ConflictException("the username is used , try another one") ;
            }else {
                account.setUsername(accountUpdateRequest.getUsername());
                if(account.getEmail() != accountUpdateRequest.getEmail()) {
                    if(accountRepo.findByEmail(accountUpdateRequest.getEmail()).isPresent()) {
                        throw new ConflictException("the email is used , try another one") ;
                    }else {
                        account.setEmail(accountUpdateRequest.getEmail());
                    }
                }
            }
        }
            return accountRepo.save(account) ;
    }
}
