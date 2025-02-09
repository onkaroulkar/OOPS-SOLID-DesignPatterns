package org.onkar.DesignPattern.Memento;

//Memento class : Stores the internal state of the text editor.
public class EditorMemento {
	private final String content;
	
	public EditorMemento(String content) {
		this.content = content;
	}
	
	public String getContent() {
		return content;
	}

}
