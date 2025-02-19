package org.onkar.DesignPattern.FacadePatternSolution;

// Microservice for user management.
public class OrderService {
	
	public String getOrderService(String orderId) {
		return "Order details for orderId: " + orderId;
	}
}
