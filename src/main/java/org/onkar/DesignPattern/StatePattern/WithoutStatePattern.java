package org.onkar.DesignPattern.StatePattern;

public class WithoutStatePattern {

	public static void main(String[] args) {
		DrectionService directionService = new DrectionService(TransportationMode.TRAIN);
        directionService.setMode(TransportationMode.CAR);

        System.out.println(directionService.getDirection());
        directionService.getETA();
	}
}
