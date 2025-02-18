package org.onkar.DesignPattern.DecoratorPatternSolution;

abstract class PizzaDecorator implements Pizza2 {
	
	protected Pizza2 decoratedPizza;
	
	public PizzaDecorator(Pizza2 piza) {
		this.decoratedPizza = piza;
	}

	@Override
	public String getDescription() {
		return decoratedPizza.getDescription();
	}

	@Override
	public double getCost() {
		return decoratedPizza.getCost();
	}
}
