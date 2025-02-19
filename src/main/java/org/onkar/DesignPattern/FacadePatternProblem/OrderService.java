package org.onkar.DesignPattern.FacadePatternProblem;

// Microservice for user management.
public class OrderService {
	
	public String getOrderService(String orderId) {
		return "Order details for orderId: " + orderId;
	}
}
