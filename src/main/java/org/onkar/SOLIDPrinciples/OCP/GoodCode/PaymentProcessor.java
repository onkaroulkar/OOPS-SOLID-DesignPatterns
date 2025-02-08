package org.onkar.SOLIDPrinciples.OCP.GoodCode;

public class PaymentProcessor {
	
	public void processPayment(PaymentMethod paymentMethod, double amount) {
		 paymentMethod.pay(amount); // run time polymorphism. 
	}

}
