package org.onkar.SOLIDPrinciples.DIP.GoodCode;

public class SMSService implements NotificationChannel{

	@Override
	public void send(String sms) {
		System.out.println("Sending SMS: "  + sms);
	}
}
==========================================================================================================================================================================================================================================================
🧠 What Is the Dependency Inversion Principle?
Formal Definition:
"High-level modules should not depend on low-level modules. Both should depend on abstractions. Abstractions should not depend on details. Details should depend on abstractions." — Robert C. Martin
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
🔍 Breaking It Down
Let’s unpack that definition into 4 key ideas:

High-level modules = Business logic (e.g., order processing, payment handling)
	
Low-level modules = Implementation details (e.g., database access, file I/O, APIs)
	
Abstractions = Interfaces or abstract classes
	
Details = Concrete classes that implement the abstractions
	
❗ Without DIP:
High-level modules directly depend on low-level modules.
Changes in low-level code (e.g., switching from MySQL to MongoDB) break the high-level logic.
	
✅ With DIP:
Both high-level and low-level modules depend on interfaces.
You can swap implementations without touching the core logic.
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
🧱 Real-World Analogy
Imagine a lamp (high-level module) that depends directly on a wall socket (low-level module). If you travel to a country with different sockets, the lamp won’t work.

Now imagine the lamp depends on a plug interface, and you can use an adapter for any socket. That’s Dependency Inversion—the lamp doesn’t care about the socket type anymore.
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
🧪 Code Example: Without DIP (Tightly Coupled)

class MySQLDatabase {
    public void save(String data) {
        System.out.println("Saving to MySQL: " + data);
    }
}

class OrderService {
    private MySQLDatabase db = new MySQLDatabase();

    public void placeOrder(String order) {
        db.save(order);
    }
}
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
❌ Problems:
OrderService is tightly coupled to MySQLDatabase.
You can’t easily switch to another database.
Hard to test (you can’t mock the database).
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
✅ Code Example: With DIP (Loosely Coupled)

Step 1: Define an abstraction
interface Database {
    void save(String data);
}
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Step 2: Implement the abstraction
class MySQLDatabase implements Database {
    public void save(String data) {
        System.out.println("Saving to MySQL: " + data);
    }
}

class MongoDBDatabase implements Database {
    public void save(String data) {
        System.out.println("Saving to MongoDB: " + data);
    }
}
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Step 3: Depend on the abstraction
class OrderService {
    private Database db;

    public OrderService(Database db) {
        this.db = db;
    }

    public void placeOrder(String order) {
        db.save(order);
    }
}
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Step 4: Inject the dependency
public class Main {
    public static void main(String[] args) {
        Database db = new MySQLDatabase(); // or new MongoDBDatabase()
        OrderService service = new OrderService(db);
        service.placeOrder("Order #123");
    }
}
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
🧰 In Spring Boot: Real-World Example
Spring Boot naturally supports DIP using dependency injection

public interface NotificationService {
    void send(String message);
}

@Service
public class EmailNotificationService implements NotificationService {
    public void send(String message) {
        System.out.println("Sending email: " + message);
    }
}

@Service
public class SMSNotificationService implements NotificationService {
    public void send(String message) {
        System.out.println("Sending SMS: " + message);
    }
}

@RestController
public class NotificationController {
    private final NotificationService service;

    @Autowired
    public NotificationController(NotificationService service) {
        this.service = service;
    }

    @PostMapping("/notify")
    public void notify(@RequestBody String message) {
        service.send(message);
    }
}
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

📌 Summary
DIP is about decoupling high-level logic from low-level details.
Use interfaces or abstract classes to define contracts.
Let concrete classes implement those contracts.
Use dependency injection to wire everything together.
==========================================================================================================================================================================================================================================================
