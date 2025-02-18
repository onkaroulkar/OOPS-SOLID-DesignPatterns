package org.onkar.DesignPattern.DecoratorPatternSolution;

public class CheeseDecorator extends PizzaDecorator {

	public CheeseDecorator(Pizza2 piza) {
		super(piza);
	}

	public String getDescription() {
		return decoratedPizza.getDescription() + ", Cheese";
	}
	
	public double getCost() {
		return decoratedPizza.getCost() + 1.00;
	}
}
