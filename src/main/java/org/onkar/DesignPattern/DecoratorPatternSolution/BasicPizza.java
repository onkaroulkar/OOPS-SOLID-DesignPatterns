package org.onkar.DesignPattern.DecoratorPatternSolution;

public class BasicPizza implements Pizza2{

	@Override
	public String getDescription() {
		return "Basic Pizza";
	}

	public double getCost() {
		return 5.00;   // base cost
	}
}
