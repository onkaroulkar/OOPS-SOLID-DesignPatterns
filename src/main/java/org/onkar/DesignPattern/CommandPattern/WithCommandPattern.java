package org.onkar.DesignPattern.CommandPattern;

// command interface
interface Command {
	void execute();
}

// concrete class for commands
class BoldCommad implements Command {

	private TextEditorII textEditor;

	public BoldCommad(TextEditorII tx) {
		this.textEditor = tx;
	}

	@Override
	public void execute() {
		textEditor.boldText();
	}

}

class Button {
	private Command command;

	public void setCommand(Command command) {
		this.command = command;
	}

	void click() {
		command.execute();
	}

}

class TextEditorII {

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

public class WithCommandPattern {
	public static void main(String[] args) {
		TextEditorII tx = new TextEditorII();
		Button btn = new Button();
		btn.setCommand(new BoldCommad(tx));
		btn.click();
	}

}
