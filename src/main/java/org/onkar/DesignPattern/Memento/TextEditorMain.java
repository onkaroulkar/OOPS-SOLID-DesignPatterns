package org.onkar.DesignPattern.Memento;

/* A text editor where the user can undo changes, such as text addition, 
   or formatting. The editor stores snapshots of its state(text content)
   after each change, enabling the user to revert to previous state */
public class TextEditorMain {

	public static void main(String[] args) {
		TextEditor editor = new TextEditor();
		Caretaker caretaker = new Caretaker(); // History / stateMgmt
		editor.write("Hello Onkar");
		caretaker.saveState(editor);
		editor.write("Hello Subha");
		caretaker.saveState(editor);
		caretaker.undo(editor);
		
		System.out.println(editor.getContent());
	}
}
