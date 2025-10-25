package com.architectexpress.impl;

import com.architectexpress.interfaces.EmailService;

public class EmailServiceImpl implements EmailService {
    @Override
    public void sendEmailToAdmin(String message) {
        String emailHost = "email.mycompany.com";
        String recipient = "admin@mycompany.com";
        System.out.printf("Email sent to %s via %s: %s%n", recipient, emailHost, message);
    }
}
