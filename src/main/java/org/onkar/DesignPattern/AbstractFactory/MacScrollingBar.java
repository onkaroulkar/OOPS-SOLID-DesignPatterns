package org.onkar.DesignPattern.AbstractFactory;

public class MacScrollingBar implements ScrollBar{

	@Override
	public void scroll() {
		System.out.println("Scrolling Mac scrolling bar");
	}
}
