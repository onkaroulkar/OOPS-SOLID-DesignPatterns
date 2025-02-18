package org.onkar.DesignPattern.DecoratorPatternSolution;

import org.onkar.DesignPattern.DecoratorPattern.CheesePizza;
import org.onkar.DesignPattern.DecoratorPattern.Pizza;

public class PizzaApp {
	public static void main(String[] args) {
		// Basic Pizza
		Pizza2 pizza =  new BasicPizza();
		
		// Add Cheese
		pizza = new CheeseDecorator(pizza);
		System.out.println(pizza.getDescription());
		System.out.println(pizza.getCost());
	}
}
