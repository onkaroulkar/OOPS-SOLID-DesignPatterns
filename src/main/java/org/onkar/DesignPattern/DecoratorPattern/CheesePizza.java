package org.onkar.DesignPattern.DecoratorPattern;

public class CheesePizza extends BasicPizza{
	
	@Override
	public String getDescription() {
		return super.getDescription()+ "Cheese";
	}

	public double getCost() {
		return super.getCost()+ 5.00;   // base cost
	}
}
