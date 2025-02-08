package org.onkar.SOLIDPrinciples.OCP.GoodCode;

public class main {

	 static void main(String[] args) {
		
		 PaymentProcessor processor = new PaymentProcessor();
		 PaymentMethod creditCard = new CreditCard();
		 
		 processor.processPayment(creditCard,1000);
	}
}
