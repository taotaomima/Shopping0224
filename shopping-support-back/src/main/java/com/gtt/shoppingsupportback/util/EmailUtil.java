package com.gtt.shoppingsupportback.util;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class EmailUtil {

    @Resource
    private JavaMailSender mailSender;


    public void sendRestCode(String fromEmail,String email,String content,String title){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(fromEmail);
        message.setTo(email);
        message.setSubject(title);
        message.setText(content);
        mailSender.send(message);

    }
}
