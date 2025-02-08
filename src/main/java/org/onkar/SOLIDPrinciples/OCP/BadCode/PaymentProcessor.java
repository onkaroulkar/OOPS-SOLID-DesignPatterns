package org.onkar.SOLIDPrinciples.OCP.BadCode;

public class PaymentProcessor {
	
	public void processPayment(String paymentMethod, double amount) {
		if(paymentMethod.equals("CreditCard")) {
			
			//business logic
			System.out.println("Making Payment via Credit card " + amount);
		}
		else if(paymentMethod.equals("DebitCard")) {
			
			//business logic
			System.out.println("Making payment via Debit card " + amount);
		}
		else if(paymentMethod.equals("PayPal")) {
			
			// business logic
			System.out.println("Making Payment via PayPal " + amount);
		}
		else {
			throw new IllegalArgumentException("Unsuopported payment method " + paymentMethod);
		}
	}
}
 
