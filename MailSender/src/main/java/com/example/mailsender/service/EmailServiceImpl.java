package com.example.mailsender.service;

import com.example.mailsender.dto.MessageDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Objects;

/**
 * @author Vladimir Solovyov
 * @project mail_proxy
 * @date on 25/01/2022
 */

@Slf4j
@Service
public class EmailServiceImpl implements EmailService {

    private static final String EMAIL_RECEIVER = "thegreatestemailname@gmail.com";

    public JavaMailSender mailSender;

    public EmailServiceImpl(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Override
    public SimpleMailMessage createMessage() {
        var message = new SimpleMailMessage();
        message.setTo(EMAIL_RECEIVER);
        message.setSubject("test email");
        message.setText("it is a test message");
        return message;
    }

    @Override
    public MessageDto createMessageDto(SimpleMailMessage simpleMailMessage) {
        var message = createMessage();
        return MessageDto.builder()
                .messageReceiver(Arrays.toString(Objects.requireNonNull(message.getTo())))
                .messageSubject(message.getSubject())
                .messageText(message.getText())
                .build();
    }

    @Override
    public void sendMessage(String email) {
        var message = createMessage();
        mailSender.send(message);
        log.info(String.format("*** message %s send ***", message));
    }
}
