package org.onkar.DesignPattern.AbstractFactory;

// concrete implementation
public class MacFactory implements UIFactory {

	@Override
	public Button createButton() {
		return new MacButton();
	}

	@Override
	public ScrollBar createScrollBar() {
		return new MacScrollingBar();
	}
}
