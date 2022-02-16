package com.example.mailsender.service;

import com.example.mailsender.dto.MessageDto;
import org.springframework.mail.SimpleMailMessage;

/**
 * @author Vladimir Solovyov
 * @project mail_proxy
 * @date on 25/01/2022
 */

public interface EmailService {
    SimpleMailMessage createMessage();
    MessageDto createMessageDto(SimpleMailMessage message);
    void sendMessage(String email);
}
