package org.onkar.SOLIDPrinciples.ISP.GoodCode;

import org.onkar.SOLIDPrinciples.ISP.BadCode.Document;

public interface Copier {
	void copy(Document doc);
}

=============================================================================================================================================================================================================

🔍 What Is the Interface Segregation Principle?

Interfaces should be small, focused, and role-specific.
A class should only implement the methods it actually needs.
Avoid creating "fat" interfaces that try to do too much.
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
🧠 Why Does This Principle Exist?
Imagine you're building a system with different types of devices or users. If you create one large interface with many methods, every class that implements it must define all those methods—even if some are irrelevant.

This leads to:

Dummy implementations (e.g., throw new NotImplementedException())
Code fragility (changes in the interface affect unrelated classes)
Violation of the Single Responsibility Principle
Tight coupling between unrelated behaviors
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
🧪 Real-World Analogy
Imagine a universal remote with 100 buttons. You only use 3 of them. The rest are confusing, unnecessary, and make the remote harder to use. Wouldn’t it be better to have a remote with just the buttons you need?

That’s what ISP is about: customizing interfaces to the needs of the client.
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
🧱 Code Example: The Wrong Way (Violating ISP)
interface Machine {
    void print();
    void scan();
    void fax();
}

class OldPrinter implements Machine {
    public void print() {
        System.out.println("Printing...");
    }

    public void scan() {
        throw new UnsupportedOperationException("Scan not supported");
    }

    public void fax() {
        throw new UnsupportedOperationException("Fax not supported");
    }
}
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
❌ Problems:
OldPrinter is forced to implement scan() and fax() even though it doesn’t support them.
This violates ISP.
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
✅ Code Example: The Right Way (Following ISP)
interface Printer {
    void print();
}

interface Scanner {
    void scan();
}

interface Fax {
    void fax();
}

class OldPrinter implements Printer {
    public void print() {
        System.out.println("Printing...");
    }
}

class MultiFunctionPrinter implements Printer, Scanner, Fax {
    public void print() {
        System.out.println("Printing...");
    }

    public void scan() {
        System.out.println("Scanning...");
    }

    public void fax() {
        System.out.println("Faxing...");
    }
}
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
✅ Benefits:
Each class only implements what it needs.
Interfaces are modular, reusable, and easy to maintain.
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
🧰 When to Apply ISP
When you notice classes implementing methods they don’t use.
When interfaces start growing too large.
When different clients use different subsets of an interface.
When you want to decouple parts of your system for better testability and flexibility.
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
🧠 Key Takeaways
Concept	                                         Description
Fat Interface	                                 An interface with too many unrelated methods.
Client	                                         A class that depends on an interface.
Segregation	                                 Splitting large interfaces into smaller, more specific ones.
Goal	                                         Reduce coupling and increase cohesion.
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
.
📌 Summary
ISP is about designing interfaces that are client-specific.
It promotes clean, modular, and maintainable code.
It works hand-in-hand with other SOLID principles like SRP and DIP.
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
🧩 Scenario: Notification System
Imagine you're building a notification system in a Spring Boot application that supports multiple channels:

Email
SMS
Push Notification
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
❌ Problem: A Fat Interface
public interface Notifier {
    void sendEmail(String message);
    void sendSMS(String message);
    void sendPushNotification(String message);
}

Now, if you implement an EmailNotifier, you’re forced to implement all three methods—even if it only sends emails:
@Component
public class EmailNotifier implements Notifier {
    public void sendEmail(String message) {
        // send email
    }

    public void sendSMS(String message) {
        // not supported
        throw new UnsupportedOperationException();
    }

    public void sendPushNotification(String message) {
        // not supported
        throw new UnsupportedOperationException();
    }
}
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
This violates ISP because EmailNotifier is forced to depend on methods it doesn’t use.
✅ Solution: Apply Interface Segregation
Split the large interface into smaller, role-specific interfaces:

public interface EmailSender {
    void sendEmail(String message);
}

public interface SMSSender {
    void sendSMS(String message);
}

public interface PushNotifier {
    void sendPushNotification(String message);
}

Now, each class implements only what it needs:
@Component
public class EmailNotifier implements EmailSender {
    public void sendEmail(String message) {
        // send email logic
    }
}

@Component
public class SMSNotifier implements SMSSender {
    public void sendSMS(String message) {
        // send SMS logic
    }
}

@Component
public class PushNotificationService implements PushNotifier {
    public void sendPushNotification(String message) {
        // send push notification logic
    }
}
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
🧠 Benefits in Spring Boot
Loose coupling: Each service is independent and easier to test.
Better dependency injection: You can inject only the interface you need.
Cleaner code: No dummy or unsupported methods.
Scalability: Easy to add new notification types without modifying existing code
=========================================================================================================================================================================================================
