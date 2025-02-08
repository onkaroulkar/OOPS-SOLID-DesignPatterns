package org.onkar.SOLIDPrinciples.OCP.GoodCode;

public class DebitCard implements PaymentMethod{

	@Override
	public void pay(double amount) {
		System.out.println("Making Payment via Debit card " + amount);
		
	}
}
