# SRP
❌ In the original OnDemandAgentService, multiple responsibilities were handled within a single class:

-User authentication

-Logging to a file

-Sending email notifications

-Starting an agent

This violated SRP — the class had multiple reasons to change, such as log format, email system, or authentication logic.

***After SRP Implementation:

✅ Single Responsibility Principle (SRP)

Each class has only one job:

Logging → LoggerServiceImpl

Authentication → AuthServiceImpl

Email → EmailServiceImpl

Coordination → OnDemandAgentServiceUpdated

✅ Interface Segregation

Each service has its own small, focused interface (LoggerService, AuthService, EmailService).

✅ Association Instead of DI

Dependencies are associated internally in OnDemandAgentServiceUpdated, not passed through constructors —
keeping the main program simple, while still achieving SRP.

Class Association:

    classDiagram
    class OnDemandAgentServiceUpdated {
        - LoggerService logger
        - AuthService authService
        - EmailService emailService
        + startNewOnDemandMachine()
    }
    class LoggerServiceImpl {
        + info(msg)
        + warn(msg)
        + error(msg)
    }

    class AuthServiceImpl {
        + isAuthorized(username, password)
    }

    class EmailServiceImpl {
        + sendEmailToAdmin(msg)
    }

    class OnDemandAgent {
        + host
        + ip
        + imageId
    }

    OnDemandAgentServiceUpdated --> LoggerServiceImpl : uses
    OnDemandAgentServiceUpdated --> AuthServiceImpl : uses
    OnDemandAgentServiceUpdated --> EmailServiceImpl : uses
