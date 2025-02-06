package org.onkar.Basics.OOPS;

public class CreditCard extends Card implements PaymentMethod{

	public CreditCard(String cardNo, String userName) {
		super(cardNo, userName);
	}

	@Override
	public void pay() {
		System.out.println("Making payment via credit card");
	}
}
