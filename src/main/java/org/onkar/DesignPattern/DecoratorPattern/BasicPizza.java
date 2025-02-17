package org.onkar.DesignPattern.DecoratorPattern;

public class BasicPizza implements Pizza {

	@Override
	public String getDescription() {
		return "Basic Pizza";

	}

	public double getCost() {
		return 5.00;   // base cost
	}
}
