package com.example.mailsender.controller;

import com.example.mailsender.dto.MessageDto;
import com.example.mailsender.service.EmailServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Vladimir Solovyov
 * @project MailSender
 * @date on 24/01/2022
 */

@RestController
public class EmailController {

    private static final String EMAIL_RECEIVER = "thegreatestemailname@gmail.com";

    private EmailServiceImpl emailService;

    public EmailController(EmailServiceImpl emailService) {
        this.emailService = emailService;
    }

    @RequestMapping("/send")
    public ResponseEntity<MessageDto> sendEmail() {
        var message = emailService.createMessage();
        var messageDto = emailService.createMessageDto(message);

        emailService.sendMessage(EMAIL_RECEIVER);

        return ResponseEntity.ok(messageDto);
    }
}
