package com.maytic.SpringPortfolioApp.service;

import com.maytic.SpringPortfolioApp.entity.Mail;

public interface EmailService {
    public void sendSimpleMail(String to, Mail mail);

}
