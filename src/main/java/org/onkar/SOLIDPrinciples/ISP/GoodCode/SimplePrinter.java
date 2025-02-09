package org.onkar.SOLIDPrinciples.ISP.GoodCode;

import org.onkar.SOLIDPrinciples.ISP.BadCode.Document;

public class SimplePrinter implements Printer {

	@Override
	public void Print(Document doc) {
		System.out.println("Printind the document");
	}
}
