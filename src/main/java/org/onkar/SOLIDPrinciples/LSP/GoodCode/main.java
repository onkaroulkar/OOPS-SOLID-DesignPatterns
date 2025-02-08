package org.onkar.SOLIDPrinciples.LSP.GoodCode;

public class main {
	
	public static void readAnyFile(ReadableFile file) {
		file.read();
	}

	public static void main(String[] args) {

		ReadableFile file = new ReadOnlyFile();
		file.read();
		
		WritableFile writableFile = new WritableFile();
		writableFile.read();
		writableFile.write();
		
		readAnyFile(file);
		readAnyFile(writableFile);
 
	}
}
