package com.example.mailsender.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

/**
 * @author Vladimir Solovyov
 * @project MailSender
 * @date on 24/01/2022
 */

@Configuration
public class MailConfig {

    private static final String EMAIL_SENDER = "supersonic30003@gmail.com";
    private static final String PASSWORD = "Spartak30003";

    @Bean
    public JavaMailSender getJavaMailSender() {
        var mailSender = new JavaMailSenderImpl();

        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(465);

        mailSender.setUsername(EMAIL_SENDER);
        mailSender.setPassword(PASSWORD);

        var props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.ssl.enable", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");

        return mailSender;
    }

}
