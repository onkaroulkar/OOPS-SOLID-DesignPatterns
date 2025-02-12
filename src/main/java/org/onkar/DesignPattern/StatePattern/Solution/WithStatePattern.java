package org.onkar.DesignPattern.StatePattern.Solution;

public class WithStatePattern {

	public static void main(String[] args) {
		
		DirectionService directionService = new DirectionService(new Car());
		System.out.println(directionService.getDirection());
		directionService.getETA();
	}

}
