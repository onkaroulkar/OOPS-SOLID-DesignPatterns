package org.onkar.DesignPattern.FacadePatternProblem;

public class Client {

	public static void main(String[] args) {
		
		// Client code interacting with different services.
		UserService userService = new UserService();
		OrderService orderService = new OrderService();
		PaymentService paymentService = new PaymentService();
		
		// Task
		System.out.println(userService.getUserService("123"));
		System.out.println(orderService.getOrderService("4534"));
		System.out.println(paymentService.getPaymentService("45465656"));
	}
}
