package com.med.accountservice.usersManagement.feignClient;

import com.med.accountservice.usersManagement.model.SimpleEmailDetails;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "mailing-service" , url = "http://localhost:8081/")
public interface MailingRepo {
    @PostMapping("/sendSimpleEmail")
    public void sendMail(@RequestBody SimpleEmailDetails simpleEmailDetails) ;
}
