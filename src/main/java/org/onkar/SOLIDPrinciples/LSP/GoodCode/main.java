package org.onkar.SOLIDPrinciples.LSP.GoodCode;

public class main {
	
	public static void readAnyFile(ReadableFile file) {
		file.read();
	}

	public static void main(String[] args) {

		ReadableFile file = new ReadOnlyFile();
		file.read();
		
		WritableFile writableFile = new WritableFile();
		writableFile.read();
		writableFile.write();
		
		readAnyFile(file);
		readAnyFile(writableFile);
 
	}
}

========================================================================================================================================================================
1. The Core Concept of LSP
	
Imagine you have a function that expects an object of type Animal. According to LSP, if you pass it an object of a subclass like Dog or Cat—which both derive from
Animal—then the function should operate correctly without any surprises. The subclass should honor the “contract” defined by the base class.

Key Points:
- Behavioral Compatibility: The subclass must fulfill the expectations of the base class. This includes its methods, return values, side effects, and even error
conditions.
- Contract by Design: Think of a base class as defining a contract for behavior. Derived classes must not only provide the same method names but must also adhere
to the intended behavior, including not violating any constraints (invariants) set by the base.
----------------------------------------------------------------------------------------------------------------------------------------------------------------------
2. Preconditions, Postconditions, and Invariants
	
A deeper understanding of LSP comes by considering the notions of preconditions, postconditions, and invariants—concepts often associated with "design by contract."
- Preconditions:
Conditions that must be true before a method is executed. A subclass should not strengthen these preconditions. That is, any method in a subclass must accept all inputs that the base class method accepts (or more), so as not to surprise the client code.
- Postconditions:
Conditions that are guaranteed after the method execution. A subclass should not weaken the postconditions. It should meet or exceed the guarantees provided by its base class.
- Invariants:
Conditions that must remain true for an object regardless of the operations performed on it. A subclass should maintain these invariants.

For Example:
If a base class guarantees that a method returns a positive number, then any overriding method in a subclass should also guarantee a positive number
(or follow the same or stronger behavior), not a negative value or an entirely different domain of values.

---------------------------------------------------------------------------------------------------------------------------------------------------------------------
3. Classic Examples of LSP Violation
	
Example 1: The Bird and Flight Problem
Another common example involves designing a hierarchy of birds:

abstract class Bird {
    public abstract void fly();
}

class Sparrow extends Bird {
    @Override
    public void fly() {
        System.out.println("Sparrow flying high!");
    }
}

class Penguin extends Bird {
    @Override
    public void fly() {
        // Penguins can't fly.
        throw new UnsupportedOperationException("Penguin cannot fly.");
    }
}

What Can Go Wrong?
Client code that works with Bird objects might expect to call fly() successfully on any bird. Substituting a Penguin in place of a typical flying bird would 
cause a runtime exception since Penguin doesn’t conform to the same behavioral contract—namely, that all birds can fly.
Refactoring Suggestion:
You might need to refactor the design. For instance, separate the behaviors: create an interface Flyable for birds that can fly and let penguins not implement it.
This way, client code that cares about flying can work only with Flyable objects, while still having a common abstraction for other bird behaviours.
---------------------------------------------------------------------------------------------------------------------------------------------------------------------
4. Guidelines for Adhering to LSP
	
To design systems that respect LSP:

- Design by Contract:
Clearly define what each method in your base class is expected to do—its contract. Ensure that derived classes uphold this contract.
	
- Avoid Strengthening Preconditions:
Do not make the inputs to your subclass methods more restrictive than those of the base. The client should be able to use the subclass wherever it used the 
base without changing the input assumptions.
	
- Honor Postconditions:
Your subclass should guarantee at least what the base class promises as output or effects. If additional outputs are provided, they should not contradict the original contract.
	
- No Surprising Side Effects:
Methods in the subclass should not introduce unexpected changes or side effects that would violate the behavior assumed by the users of the base class.
	
- Interface Segregation:
Often, violations occur because a base class tries to do too much. Splitting responsibilities into well-defined interfaces can help ensure that only the necessary
behaviors are implemented by a subclass.
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------
5. Benefits of Following LSP
When LSP is correctly followed, your code becomes:
- More Robust:
You can change or extend parts of the system without fear of breaking existing functionality.
- Easier to Maintain:
Small, well-defined behavioral contracts reduce the chance of unintended side effects, making the system easier to debug and modify.
- Natural for Polymorphism:
Proper substitution enhances the use of polymorphism. Client code operating on a base class is confident that any derived class will behave appropriately.
- Enhanced Reusability:
With clear contracts and behavior, components can be reused in different parts of an application or even in different applications.

6. Final Thoughts
The Liskov Substitution Principle is not simply about the syntactic relationship of inheritance but rather about the behavioral substitutes. 
A well-designed inheritance structure honors LSP by ensuring that every subclass instance can replace a base class instance without altering program correctness.
In practice, when you design a class hierarchy, always ask: "Will replacing a base class with this subclass ever break my client code?" If the answer 
can be “yes” in some situation, it’s a strong sign that the subclass is not honoring the intended contract of its parent.
----------------------------------------------------------------------------------------------------------------------------------------------------------------------
LSP following code:

// Abstract class representing common bird behaviors.
abstract class Bird {
    public abstract void eat();
    public abstract void sleep();
}

// Interface for flying behavior.
interface Flyable {
    void fly();
}

// A Sparrow is a Bird that can fly.
class Sparrow extends Bird implements Flyable {
    @Override
    public void eat() {
        System.out.println("Sparrow eats seeds.");
    }
    
    @Override
    public void sleep() {
        System.out.println("Sparrow sleeps on a branch.");
    }
    
    @Override
    public void fly() {
        System.out.println("Sparrow flies high in the sky!");
    }
}

// A Penguin is a Bird but it cannot fly.
class Penguin extends Bird {
    @Override
    public void eat() {
        System.out.println("Penguin eats fish.");
    }
    
    @Override
    public void sleep() {
        System.out.println("Penguin sleeps in its nest.");
    }
}

// Test class demonstrating the use of Bird and Flyable.
public class Main {
    public static void main(String[] args) {
        // Create a Sparrow and Penguin.
        Bird sparrow = new Sparrow();
        Bird penguin = new Penguin();
        
        // Test Sparrow functionality.
        System.out.println("Sparrow:");
        sparrow.eat();
        sparrow.sleep();
        // Ensure it can fly as it implements Flyable.
        if (sparrow instanceof Flyable) {
            ((Flyable) sparrow).fly();
        }
        
        // Test Penguin functionality.
        System.out.println("\nPenguin:");
        penguin.eat();
        penguin.sleep();
        // Penguin doesn't implement Flyable, so we check before calling fly.
        if (penguin instanceof Flyable) {
            ((Flyable) penguin).fly();
        } else {
            System.out.println("Penguin cannot fly.");
        }
    }
}

---------------------------------------------------------------------------------------------------------------------------------------------------------------------
1. The Common Abstraction
Create an interface that serves as the contract for sending notifications
package com.example.notification;

public interface NotificationService {
    void send(String message);
}
---------------------------------------------------------------------------------------------------------------------------------------------------------------------
2. Concrete Implementations
Each notification channel implements the same interface. For example:
EmailNotificationService.java
package com.example.notification;

import org.springframework.stereotype.Service;

@Service
public class EmailNotificationService implements NotificationService {
    @Override
    public void send(String message) {
        // Email-specific implementation
        System.out.println("Sending Email with message: " + message);
    }
}

---------------------------------------------------------------------------------------------------------------------------------------------------------------------
package com.example.notification;

import org.springframework.stereotype.Service;

@Service
public class SMSNotificationService implements NotificationService {
    @Override
    public void send(String message) {
        // SMS-specific implementation
        System.out.println("Sending SMS with message: " + message);
    }
}
---------------------------------------------------------------------------------------------------------------------------------------------------------------------
package com.example.notification;

import org.springframework.stereotype.Service;

@Service
public class PushNotificationService implements NotificationService {
    @Override
    public void send(String message) {
        // Push notification-specific implementation
        System.out.println("Sending Push notification with message: " + message);
    }
}
---------------------------------------------------------------------------------------------------------------------------------------------------------------------
The NotificationManager aggregates all available notification services. Spring Boot injects the list of all beans that implement the NotificationService interface,
ensuring that any channel conforming to the interface is available.
package com.example.notification;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class NotificationManager {
    private final List<NotificationService> notificationServices;

    // Spring Boot injects all NotificationService beans into this list.
    public NotificationManager(List<NotificationService> notificationServices) {
        this.notificationServices = notificationServices;
    }
    
    public void notifyAllChannels(String message) {
        for (NotificationService service : notificationServices) {
            service.send(message);
        }
    }
}
---------------------------------------------------------------------------------------------------------------------------------------------------------------------
4. Exposing the Service via a REST Controller
A REST controller provides an endpoint to trigger notifications. The controller depends only on the NotificationManager abstraction.
package com.example.notification;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    private final NotificationManager notificationManager;

    public NotificationController(NotificationManager notificationManager) {
        this.notificationManager = notificationManager;
    }

    @PostMapping
    public ResponseEntity<String> sendNotification(@RequestParam String message) {
        notificationManager.notifyAllChannels(message);
        return ResponseEntity.ok("Notifications sent successfully.");
    }
}
---------------------------------------------------------------------------------------------------------------------------------------------------------------------
5. The Main Application Class
Finally, create the Spring Boot application class to bootstrap the microservice:
package com.example.notification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NotificationServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(NotificationServiceApplication.class, args);
    }
}
=====================================================================================================================================================================

