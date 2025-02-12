package org.onkar.DesignPattern.StatePattern.Solution;

public class DirectionService {

	TransportationMode transportationMode;
	
	public DirectionService(TransportationMode transportationMode) {
		this.transportationMode = transportationMode;
	}
	
	public int getETA() {
		return transportationMode.calsETA();
	}
	
	public String getDirection() {
		return transportationMode.getDirection();
	}
	
}
