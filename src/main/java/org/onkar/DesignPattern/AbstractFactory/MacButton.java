package org.onkar.DesignPattern.AbstractFactory;

public class MacButton implements Button{

	@Override
	public void render() {
		System.out.println("Rendering MacButton");
	}
}
