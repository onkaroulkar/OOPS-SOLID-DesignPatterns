package org.onkar.Basics.OOPS;

public class UPI implements PaymentMethod{
	
	String upiId;
	
	public UPI(String upiId) {
		super();
		this.upiId = upiId;
	}
	
	@Override
	public void pay() {
		System.out.println("Making payment via UPI " + upiId);
	}
}
