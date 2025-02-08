package org.onkar.SOLIDPrinciples.LSP.BadCode;

public class main {

	public static void main(String[] args) {
		File file = new ReadOnlyFiles();
		file.read(); // works fine
		file.write(); // Throwing an exception, violation of LSP.
	}
}    
