package org.onkar.DesignPattern.StrategyPattern;

// payment strategy interface
interface PaymentStrategy {
	void processPayment();
}

class DebitCard implements PaymentStrategy {

	@Override
	public void processPayment() {
		System.out.println("Making Payment via debit card");
	}
}

class CrdeditCard implements PaymentStrategy {

	@Override
	public void processPayment() {
		System.out.println("Making Payment via credit card");
	}
}

class UPI implements PaymentStrategy {

	@Override
	public void processPayment() {
		System.out.println("Making Payment via UPI");
	}
}

// payment service class
class PaymentService {

	private PaymentStrategy strategy;

	public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
		this.strategy = paymentStrategy;
	}

	public void pay() {
		strategy.processPayment(); // polimorphic behaviour
	}
}

public class StrategyPattern {

	public static void main(String[] args) {
		PaymentService paymentService = new PaymentService();
		paymentService.setPaymentStrategy(new DebitCard());
		paymentService.pay();
	}

}
