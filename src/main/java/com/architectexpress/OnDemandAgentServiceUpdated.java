package com.architectexpress;

import com.architectexpress.impl.AuthServiceImpl;
import com.architectexpress.impl.EmailServiceImpl;
import com.architectexpress.impl.LoggerServiceImpl;
import com.architectexpress.interfaces.AuthService;
import com.architectexpress.interfaces.EmailService;
import com.architectexpress.interfaces.LoggerService;

public class OnDemandAgentServiceUpdated {
    private final LoggerService logger;
    private final AuthService authService;
    private final EmailService emailService;

    private String username;
    private String password;

    public OnDemandAgentServiceUpdated() {
        this.logger = new LoggerServiceImpl();
        this.authService = new AuthServiceImpl();
        this.emailService = new EmailServiceImpl();
    }

    public void setUsername(String username) { this.username = username; }
    public void setPassword(String password) { this.password = password; }

    public OnDemandAgent startNewOnDemandMachine() {
        logger.info("Starting on-demand agent startup logic");

        try {
            if (authService.isAuthorized(username, password)) {
                logger.info(String.format("User %s will attempt to start a new on-demand agent.", username));
                OnDemandAgent agent = startNewAmazonServer();
                emailService.sendEmailToAdmin(String.format(
                        "User %s has successfully started a machine with IP %s.", username, agent.getIp()));
                return agent;
            } else {
                logger.warn(String.format("User %s attempted to start a new on-demand agent.", username));
                throw new SecurityException("Unauthorized access to startNewOnDemandMachine.");
            }
        } catch (Exception e) {
            logger.error("Exception in on-demand agent creation: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    private OnDemandAgent startNewAmazonServer() {
        // Simulate Amazon API and start a new EC2 instance
        OnDemandAgent amazonAgent = new OnDemandAgent();
        amazonAgent.setHost("usweav-ec2.mycompany.local");
        amazonAgent.setIp("54.653.234.23");
        amazonAgent.setImageId("ami-784930");
        return amazonAgent;
    }
}
