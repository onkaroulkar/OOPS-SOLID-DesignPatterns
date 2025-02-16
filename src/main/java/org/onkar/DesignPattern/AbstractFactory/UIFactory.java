package org.onkar.DesignPattern.AbstractFactory;

// Abstract factory interface
public interface UIFactory {
	
	public Button createButton();
	public ScrollBar createScrollBar();
}
