package org.onkar.DesignPattern.FacadePatternSolution;

public class ApiGateWay {
	
	UserService userService;
	OrderService orderService;
	PaymentService paymentService;
	
	public ApiGateWay() {
		this.userService = new UserService();
		this.orderService = new OrderService();
		this.paymentService = new PaymentService();
	}
	
	public String fullOrderDetails(String userId, String orderId, String serviceId) {
		String usersDetails = userService.getUserService(userId);
		String orderDetails = orderService.getOrderService(orderId);
		String paymentDetails = paymentService.getPaymentService(serviceId);
		
		return usersDetails + "\n" + orderDetails + "\n" + paymentDetails;
	}
}
