package com.example.mailsender.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * @author Vladimir Solovyov
 * @project mail_proxy
 * @date on 25/01/2022
 */

@Data
@Builder
@AllArgsConstructor
public class MessageDto {
    private String messageReceiver;
    private String messageSubject;
    private String messageText;
}
