package com.architectexpress;

public class Main {
    public static void main(String[] args) {
        OnDemandAgentServiceUpdated service = new OnDemandAgentServiceUpdated();
        service.setUsername("Jamil");
        service.setPassword("passw0rd");

        OnDemandAgent agent = service.startNewOnDemandMachine();
        System.out.println("Started Agent: " + agent);
    }
}