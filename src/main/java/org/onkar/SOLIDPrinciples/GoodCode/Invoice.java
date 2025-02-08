package org.onkar.SOLIDPrinciples.GoodCode;

public class Invoice {
	
	private double amount;
	
	public Invoice(double amount) {
		this.amount = amount;
}
	
	// Additional Functionality
	public void generateInvoice() {
		System.out.println("Invoice generated & prited for amount " + amount);
	}	
}
