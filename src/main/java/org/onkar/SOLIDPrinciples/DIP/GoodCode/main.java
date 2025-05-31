package org.onkar.SOLIDPrinciples.DIP.GoodCode;

public class main {

	public static void main(String[] args) {
		NotificationService emailService = new NotificationService(new EmailService());
		emailService.notify("20000 send successfully");
		
		NotificationService smsService = new NotificationService(new SMSService());
		smsService.notify("50000 send successfully");
}
}

==========================================================================================================================================================================
1. The Core Definition
At its heart, SRP is about the separation of concerns. When a class is responsible for a single part of a program's functionality, it becomes much easier to understand,
maintain, and modify. The "reason to change" phrase means that if there are multiple reasons for a class to change, that class likely has multiple responsibilities, 
and each should be managed independently. Example: Imagine a class named ReportManager that handles both generating report data and formatting it for display. 
The business logic of data aggregation and the presentation logic for formatting are two very different concerns. If the reporting requirements change
(say, you need a new type of calculation) or the display criteria change (perhaps a new formatting style for print), the ReportManager class would have to 
change for two unrelated reasons. This scenario violates the SRP.
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Why SRP Matters
- Maintainability:
Code that adheres to SRP is typically easier to maintain since the changes in one aspect of functionality won't affect unrelated behaviors. For example, 
if you need to update the formatting logic, you only need to change the class concerned with presentation, not the class handling the calculations.

- Testability:
When classes have a single responsibility, unit tests can target the specific functionality without interference from other responsibilities.
This isolation makes it clearer what exactly is failing and why.

- Cohesion:
A class that follows SRP tends to have high cohesion because its methods, properties, and behaviours work together for one specific task.
High cohesion improves the clarity of the class’s role in the system.
	
- Reduced Complexity:
Splitting responsibilities means that each class remains focused and avoids taking on too many tasks. It reduces the likelihood of unintended
side effects when modifications occur.
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
3. Applying SRP in Design
When designing a system, you need to identify the different responsibilities that might be combined within a class. Here are some steps and questions to ask:

- Identify Changing Factors:
Analyse what may force a change in your code. If changes for different reasons require modifications to the same class, that class might be doing too much. For example, consider:
- Business rules updates.
- Data persistence changes.
- User interface adaptations.
- Decompose Your Class:

If a class has responsibilities for:
- Data Management: A class that handles reading/writing from a file.
- Business Logic: A class that calculates or processes data.
- Presentation: A class that formats data for display.
- Each of these is a distinct responsibility. Decomposing your class into multiple classes—like a DataReader, a BusinessProcessor, and a Presenter—follows SRP.
	
- Single Reason to Change:
Ask yourself, "What would make me change this class?" If multiple factors arise, consider splitting the responsibilities into separate classes.
--------------------------------------------------------------------------------------------------------------------------------------------------------------------
4. Benefits in Real-World Scenarios
	
- Change Management:
In a rapidly changing business environment, requirements evolve fast. When each class has a single responsibility, your system can adapt to these changes more fluidly. 
For example, a bug in the report formatting logic can be fixed without worrying about breaking the data processing logic.
	
- Improved Collaboration:
In team development, different team members can work on different aspects (or responsibilities) of the project concurrently. This clear separation reduces
merge conflicts and misunderstandings about what a class is supposed to do.
	
- Scalability:
When you need to extend functionality, new code often plugs into one responsibility. This means you maintain a clean interface and reduce the risk of disrupting existing functionality.
--------------------------------------------------------------------------------------------------------------------------------------------------------------------
5. Practical Example
Let’s illustrate with a more detailed code example in Java:
// Violating SRP: A class with two responsibilities
public class Employee {
    private String name;
    private double salary;
    
    // Business logic: Calculate raise
    public void applyRaise(double percentage) {
        salary += salary * percentage / 100;
    }
    
    // Presentation: Print employee details
    public void printEmployeeDetails() {
        System.out.println("Employee: " + name + ", Salary: " + salary);
    }
}

// Following SRP: Separate responsibilities
public class Employee {
    private String name;
    private double salary;
    
    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }
    
    public void applyRaise(double percentage) {
        salary += salary * percentage / 100;
    }
    
    public String getName() {
        return name;
    }
    
    public double getSalary() {
        return salary;
    }
}

public class EmployeePrinter {
    // Presentation responsibility is isolated here
    public void printDetails(Employee emp) {
        System.out.println("Employee: " + emp.getName() + ", Salary: " + emp.getSalary());
    }
}

In this refactored example, the Employee class handles only business logic related to the employee’s data, while EmployeePrinter is dedicated to presentation. 
Any changes in formatting the employee details won’t affect how salary is computed or stored.
---------------------------------------------------------------------------------------------------------------------------------------------------------------------
6. Limitations and Over-Splitting
	
While SRP is fundamental, overzealous application might lead to fragmentation of functionality into many tiny classes, which can sometimes increase complexity and 
reduce readability. The key is to strike a balance—allowing for focused responsibilities without creating an overly fragmented architecture.
	
- Practical Consideration:
For very small applications or simple utility classes, over-abstracting might lead to unnecessary complexity. The application of SRP should be balanced with the 
overall complexity and size of the project.
====================================================================================================================================================================
