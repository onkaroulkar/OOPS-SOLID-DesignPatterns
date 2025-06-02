package org.onkar.SOLIDPrinciples.OCP.GoodCode;

public class main {

	 static void main(String[] args) {
		
		 PaymentProcessor processor = new PaymentProcessor();
		 PaymentMethod creditCard = new CreditCard();
		 
		 processor.processPayment(creditCard,1000);
	}
}

=======================================================================================================================================================================
At its core, OCP is about building systems that evolve without breaking existing code. You design abstractions so that new behaviors plug in seamlessly, while 
the “old” code remains untouched and proven.
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------
1. Why OCP Matters
- Stability
Once you’ve tested and deployed a class, you want to avoid changing its source. Every modification risks introducing new bugs.
- Extensibility
New requirements—feature flags, different data formats, alternative business rules—should slot in without rewriting core logic.
- Maintainability
When code changes are localized to new modules or subclasses, it’s far easier to reason about, review, and test.
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------
2. Identifying OCP Violations
A quick code smell:
Whenever you add a new if/else or switch on a type or a mode inside an existing class, you’re modifying it to support new behavior.

public class ShippingCalculator {
  public double calculate(Order order, String country) {
    if (country.equals("US")) {
      return order.getWeight() * 1.2;
    } else if (country.equals("UK")) {
      return order.getWeight() * 1.5;
    }
    // – What about Canada? Australia? Brazil?
  }
}

Every time you support “France” or “India,” you must open this class and change it—violating OCP.
---------------------------------------------------------------------------------------------------------------------------------------------------------------------
3. Applying OCP: A Step-by-Step Guide
   1.Spot the “what varies”
In the example above, the rate per country varies.
   2.Extract an abstraction
Define an interface for “rate calculation.

public interface ShippingRate {
  double compute(Order order);
}

  3. Encapsulate each variant
public class USShippingRate implements ShippingRate {
  public double compute(Order order) {
    return order.getWeight() * 1.2;
  }
}

public class UKShippingRate implements ShippingRate {
  public double compute(Order order) {
    return order.getWeight() * 1.5;
  }
}

4. Inject via configuration or factor
public class ShippingCalculator {
  private final ShippingRate rate;

  public ShippingCalculator(ShippingRate rate) {
    this.rate = rate;
  }

  public double calculate(Order order) {
    return rate.compute(order);
  }
}
5. - Add new countries without touching ShippingCalculator
To support Canada, simply add CanadaShippingRate and wire it up.
---------------------------------------------------------------------------------------------------------------------------------------------------------------------
4. Design Patterns That Leverage OCP
- Strategy Pattern
Encapsulates algorithms (shipping rates, sorting strategies) behind a common interface.
- Template Method
Defines a skeleton algorithm in a base class, with “hook” methods overridden by subclasses.
- Decorator Pattern
Extends behavior by wrapping objects without modifying their code.
- Factory Method / Abstract Factory
Delegates object creation to subclasses—new variants can be registered without altering client code.
---------------------------------------------------------------------------------------------------------------------------------------------------------------------
6. Common Pitfalls
- Over-Abstraction
Creating dozens of tiny interfaces without justified variation can make your code fragmented and harder to navigate.
- Premature Application
Abstracting “just in case” inflates the architecture. Only apply OCP when you see real or imminent variations.
- Hidden Dependencies
Relying on global state or static methods makes it hard to inject new behaviors at runtime.
---------------------------------------------------------------------------------------------------------------------------------------------------------------------
Testing & Versioning Benefits
- Mocking & Stubbing
You can swap out concrete implementations for test doubles effortlessly.
- Plugin Architectures
Designing around OCP often leads naturally to plugin systems—new modules drop in without recompiling the core.
=====================================================================================================================================================================
