package org.onkar.Basics.OOPS;

public class Client {

	public static void main(String [] args) {
		
		PaymentService ps = new PaymentService();
		ps.addPaymentMethod("OnkarsDebitCard", new DebitCard("1234","onkar oulkar"));
		ps.addPaymentMethod("onkarCreditCard", new CreditCard("123445","onkar oulkar"));
		ps.addPaymentMethod("UPIPayment",new UPI("1213"));
		
		ps.makePayment("UPIPayment");
	}
}