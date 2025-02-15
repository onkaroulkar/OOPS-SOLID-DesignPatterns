package org.onkar.DesignPattern.FactoryPattern;

public class TransportService {

	public static void main(String[] args) {
		// Direct create object.
		Transport vehicle = TransportFactory.createTransport("car");
		vehicle.deliver();
	}

}
