package org.onkar.SOLIDPrinciples.DIP.GoodCode;

public class SMSService implements NotificationChannel{

	@Override
	public void send(String sms) {
		System.out.println("Sending SMS: "  + sms);
	}
}
========================================================================================================================================================================================================
🧠 What Is the Dependency Inversion Principle?
Formal Definition:
"High-level modules should not depend on low-level modules. Both should depend on abstractions. Abstractions should not depend on details. Details should depend on abstractions." — Robert C. Martin
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
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
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
🧱 Real-World Analogy
Imagine a lamp (high-level module) that depends directly on a wall socket (low-level module). If you travel to a country with different sockets, the lamp won’t work.

Now imagine the lamp depends on a plug interface, and you can use an adapter for any socket. That’s Dependency Inversion—the lamp doesn’t care about the socket type anymore.
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
