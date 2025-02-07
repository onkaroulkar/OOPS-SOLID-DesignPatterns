package org.onkar.Basics.OOPS;

public class Wallet implements PaymentMethod{

	@Override
	public void pay() {
		System.out.println("Making Payment via wallet");
	}
}
