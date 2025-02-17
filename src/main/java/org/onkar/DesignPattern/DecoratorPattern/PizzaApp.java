package org.onkar.DesignPattern.DecoratorPattern;

public class PizzaApp {

	public static void main(String[] args) {
		Pizza pizza = new CheesePizza();
		System.out.println(pizza.getCost());
		System.out.println(pizza.getDescription());
	}
}
