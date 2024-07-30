package com.med.accountservice.mailingManagement.service;


import com.med.accountservice.mailingManagement.entity.SimpleEmailDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
@Service
public class MailingService {

    @Autowired
    private JavaMailSender javaMailSender ;
    public void sendSimpleMail(SimpleEmailDetails simpleEmailDetails) {
        if(simpleEmailDetails.getMsg() == null || simpleEmailDetails.getTo() == null || simpleEmailDetails.getSubject() == null) {
            System.out.println("invalid data");
        }else {
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage() ;
            simpleMailMessage.setFrom("mohamedelafia723@gmail.com");
            simpleMailMessage.setTo(simpleEmailDetails.getTo());
            simpleMailMessage.setSubject(simpleEmailDetails.getSubject());
            simpleMailMessage.setText(simpleEmailDetails.getMsg());
            javaMailSender.send(simpleMailMessage) ;
        }
    }
}
