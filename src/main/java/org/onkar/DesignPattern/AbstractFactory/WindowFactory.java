package org.onkar.DesignPattern.AbstractFactory;

// concrete implementation
public class WindowFactory implements UIFactory {

	@Override
	public Button createButton() {
		return new WindowsButton();
	}

	@Override
	public ScrollBar createScrollBar() {
		return new WindowsScrollBar();
	}
}
