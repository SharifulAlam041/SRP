package com.architectexpress;

import java.io.FileWriter;
import java.io.IOException;

public class OnDemandAgentService {
    private String username;
    private String password;

    public OnDemandAgent startNewOnDemandMachine() {
        logInfo("Starting on-demand agent startup logic");
        try {
            if (isAuthorized(username, password)) {
                logInfo(String.format("User %s will attempt to start a new on-demand agent.", username));
                OnDemandAgent agent = startNewAmazonServer();
                sendEmailToAdmin(String.format("User %s has successfully started a machine with IP %s.", username, agent.getIp()));
                return agent;
            } else {
                logWarning(String.format("User %s attempted to start a new on-demand agent.", username));
                throw new SecurityException("Unauthorized access to startNewOnDemandMachine method.");
            }
        } catch (Exception ex) {
            logError("Exception in on-demand agent creation logic: " + ex.getMessage());
            throw new RuntimeException(ex);
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private OnDemandAgent startNewAmazonServer() {
        // Simulate Amazon API and start a new EC2 instance
        OnDemandAgent amazonAgent = new OnDemandAgent();
        amazonAgent.setHost("usweav-ec2.mycompany.local");
        amazonAgent.setIp("54.653.234.23");
        amazonAgent.setImageId("ami-784930");
        return amazonAgent;
    }

    private void logInfo(String info) {
        appendToLog("INFO: " + info);
    }

    private void logWarning(String warning) {
        appendToLog("WARNING: " + warning);
    }

    private void logError(String error) {
        appendToLog("ERROR: " + error);
    }

    private void appendToLog(String message) {
        try (FileWriter writer = new FileWriter("C:\\log\\log.txt", true)) {
            writer.write(message + System.lineSeparator());
        } catch (IOException e) {
            System.err.println("Failed to write log: " + e.getMessage());
        }
    }

    private boolean isAuthorized(String username, String password) {
        return "admin".equals(username) && "passw0rd".equals(password);
    }

    private void sendEmailToAdmin(String message) {
        String emailHost = "email.mycompany.com";
        String recipient = "admin@mycompany.com";
        // actual email sending implementation omitted
        System.out.printf("Email sent to %s via %s: %s%n", recipient, emailHost, message);
    }
}

