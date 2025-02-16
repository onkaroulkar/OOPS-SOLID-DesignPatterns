package org.onkar.DesignPattern.AbstractFactory;

public class WindowsScrollBar implements ScrollBar {

	@Override
	public void scroll() {
			System.out.println("Scrolling windows scrolling bar");
	}
}
