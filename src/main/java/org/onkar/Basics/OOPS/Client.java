package org.onkar.Basics.OOPS;

public class Client {

	public static void main(String [] args) {
		
		PaymentService ps = new PaymentService();
		ps.addPaymentMethod("OnkarDebitCard", new DebitCard("1234","onkar oulkar"));
		ps.addPaymentMethod("OnkarCreditCard", new CreditCard("123445","onkar oulkar"));
		ps.addPaymentMethod("UPIPayment",new UPI("1213"));
		ps.addPaymentMethod("OnkarWallet",new Wallet());
		ps.makePayment("UPIPayment");
		ps.makePayment("OnkarWallet");
	}
}