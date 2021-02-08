package com.maytic.SpringPortfolioApp.controller;

import com.maytic.SpringPortfolioApp.entity.Mail;
import com.maytic.SpringPortfolioApp.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Controller handles mail services for the client
 */
@CrossOrigin
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
