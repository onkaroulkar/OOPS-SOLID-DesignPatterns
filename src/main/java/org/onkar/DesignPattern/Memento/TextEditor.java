package org.onkar.DesignPattern.Memento;

public class TextEditor {
	
	private String content;
	
	public void write(String text) {
		this.content = text;
	}
	
	 // Save the current state of the editor 
	public EditorMemento save() {
		return new EditorMemento(content);
	}
	
	// Restore (Memeto->update the state of the current content)
	public void restore(EditorMemento memento) {
		content = memento.getContent();
	}

	public String getContent() {
		return content;
	}
}
