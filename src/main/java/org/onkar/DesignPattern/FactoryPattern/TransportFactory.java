package org.onkar.DesignPattern.FactoryPattern;

public class TransportFactory {
	
	public static Transport createTransport(String type) {
		switch(type.toLowerCase()) {
		case "car":
			return new Car();
		case "bus":
		return new Bus();
		case "train":
			return new Train();
		default:
			throw new IllegalArgumentException("Unsupported string input");
		}
	}
}
