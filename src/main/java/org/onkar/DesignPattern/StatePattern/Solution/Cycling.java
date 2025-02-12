package org.onkar.DesignPattern.StatePattern.Solution;

public class Cycling implements TransportationMode{

	@Override
	public int calsETA() {
		System.out.println("Calculation ETA for cycling");
		return 5;
	}

	@Override
	public String getDirection() {
		
		return "Dirction for cycling";
	}

}
