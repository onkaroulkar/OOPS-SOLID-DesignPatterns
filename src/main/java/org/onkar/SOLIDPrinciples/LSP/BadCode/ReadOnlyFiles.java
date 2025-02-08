package org.onkar.SOLIDPrinciples.LSP.BadCode;

public class ReadOnlyFiles extends File{
	public void write() {
		throw new UnsupportedOperationException("Cant't write to a read only file");
	}
}
