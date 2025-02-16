package org.onkar.DesignPattern.AbstractFactory;

public class WindowsButton implements Button{

	@Override
	public void render() {
		System.out.println("Rending windows button");
	}
}