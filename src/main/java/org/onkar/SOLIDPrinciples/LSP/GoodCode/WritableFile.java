package org.onkar.SOLIDPrinciples.LSP.GoodCode;

public class WritableFile extends ReadableFile implements Writable{

	@Override
	public void write() {
		System.out.println("writing to a file......");
	}
}
 