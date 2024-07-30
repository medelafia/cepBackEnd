package com.med.accountservice.messagesManagement.repository;

import com.med.accountservice.messagesManagement.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;

public interface MessageRepo extends JpaRepository<Message , Integer > {
    public List<Message> findAllByUnRead(boolean read ) ;
    public List<Message> findAllByDateAndUnRead(Date date , boolean isRead ) ;
}
