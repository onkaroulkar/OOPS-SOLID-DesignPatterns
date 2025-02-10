package org.onkar.DesignPattern.CommandPattern;

class TextEditor {

	public void boldText() {
		System.out.println("Text has been bolded");
	}

	public void italicizeText() {
		System.out.println("Text has been Italicized");
	}

	public void underlineText() {
		System.out.println("Text has been undelined");
	}
}

class BoldButton {
	private TextEditor textEditor;

	public BoldButton(TextEditor textEditor) {
		this.textEditor = textEditor;
	}

	public void click() {
		textEditor.boldText();
	}
}

public class WithoutCommandPattern {
	public static void main(String[] args) {

		TextEditor text = new TextEditor();
		BoldButton btn = new BoldButton(text);
		btn.click();
	}
}
