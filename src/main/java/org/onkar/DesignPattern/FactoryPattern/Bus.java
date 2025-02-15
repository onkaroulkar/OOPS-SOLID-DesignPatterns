package org.onkar.DesignPattern.FactoryPattern;

public class Bus implements Transport {

	@Override
	public void deliver() {
		System.out.println("Delivering by bus");
	}

}
