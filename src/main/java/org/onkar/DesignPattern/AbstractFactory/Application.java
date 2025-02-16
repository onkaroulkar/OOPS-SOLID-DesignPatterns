package org.onkar.DesignPattern.AbstractFactory;

public class Application {

	private Button button;
	private ScrollBar scrollBar;

	public Application(UIFactory factory) {
		this.button = factory.createButton();
		this.scrollBar = factory.createScrollBar();
	}

	public void render() {
		button.render();
		scrollBar.scroll();
	}

	public static void main(String[] args) {
		Application apk = new Application(new WindowFactory());
		apk.render();
		Application ap = new Application(new MacFactory());
		ap.render();
	}
}
