package org.onkar.DesignPattern.TemplateMethodPattern;

abstract class DataParser{
	
	// Template method defines the steps of the Algorithm
	public void parser() {
		openFile();
		parseData();
		closeFile();
	}
	
	protected void openFile() {
		System.out.println("Opening the file ");
	}
	
	protected void closeFile() {
		System.out.println("Closing the file");
	}
	
	protected abstract void parseData();
}

class CSVParserI extends DataParser{

	@Override
	protected void parseData() {
		System.out.println("Parsing the CSV data");
	}
}

class JSONParserI extends DataParser{

	@Override
	protected void parseData() {
		System.out.println("Parsing the JSON data");
	}
}


public class WithTemplatePattern {

	public static void main(String[] args) {
		CSVParserI csvParser = new CSVParserI();
		JSONParserI jsonParse = new JSONParserI();
		csvParser.parseData();
		jsonParse.parseData();
	}
}


