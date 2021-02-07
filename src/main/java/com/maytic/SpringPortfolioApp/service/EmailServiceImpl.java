package com.maytic.SpringPortfolioApp.service;

import com.maytic.SpringPortfolioApp.entity.Mail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailServiceImpl implements EmailService{

    @Autowired
    private JavaMailSender javaMailSender;

    // send mail to my email from client website
    @Override
    public void sendSimpleMail(String to, Mail mail) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(mail.getFrom());
        message.setTo(to);
        message.setText("Name: " + mail.getName() + "\n" + mail.getText() + "\nEmail: " + mail.getFrom());
        message.setSubject("Portfolio");

        javaMailSender.send(message);

    }
}
