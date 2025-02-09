package org.onkar.SOLIDPrinciples.ISP.BadCode;

public class SimplePrinter implements Machine {

	@Override
	public void print(Document doc) {
		System.out.println("Printing the document...");
		
	}

	@Override
	public void scan(Document doc) {
		throw new UnsupportedOperationException("Scan is not supported.");
		
	}

	@Override
	public void copy(Document doc) {
		throw new UnsupportedOperationException("Coping is not supported");
		
	}
}
