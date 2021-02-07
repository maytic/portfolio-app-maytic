package com.maytic.SpringPortfolioApp.controller;

import com.maytic.SpringPortfolioApp.entity.Mail;
import com.maytic.SpringPortfolioApp.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller handles mail services for the client
 */
@RestController
public class MailController {

    @Autowired
    EmailService emailService;

    /**
     * send mail
     * @param mail
     */
    @PostMapping("/mail")
    public void sendMail(@RequestBody Mail mail){

        emailService.sendSimpleMail("mTorres557531@gmail.com",mail);

    }
}
