package org.onkar.DesignPattern.FacadePatternSolution;

public class Client {

	public static void main(String[] args) {
		
		// Client code interacting with API GateWay(Fasad)
		ApiGateWay apiGateWay = new ApiGateWay();
		
		// Task
		System.out.println(apiGateWay.fullOrderDetails("124","5633657","636356"));
	}
}