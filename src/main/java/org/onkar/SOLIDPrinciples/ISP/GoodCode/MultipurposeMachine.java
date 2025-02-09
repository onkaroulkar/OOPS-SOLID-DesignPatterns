package org.onkar.SOLIDPrinciples.ISP.GoodCode;

import org.onkar.SOLIDPrinciples.ISP.BadCode.Document;

public class MultipurposeMachine implements Printer,Scanner,Copier{

	@Override
	public void copy(Document doc) {
		System.out.println("Coping the documen...");
		
	}

	@Override
	public void scan(Document doc) {
		System.out.println("Scanning the document...");
		
	}

	@Override
	public void Print(Document doc) {
		System.out.println("Printing the document.... ");
		
	}

}
