package org.onkar.DesignPattern.StatePattern.Solution;

public class Car implements TransportationMode{

	@Override
	public int calsETA() {
		System.out.println("Calculatin ETA for car");
		return 4;
	}

	@Override
	public String getDirection() {	
		return "Direction for car";
	}

}
