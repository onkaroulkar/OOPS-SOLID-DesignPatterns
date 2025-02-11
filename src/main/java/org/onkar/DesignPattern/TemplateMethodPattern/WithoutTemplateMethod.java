package org.onkar.DesignPattern.TemplateMethodPattern;

// CSV parser
class CSVParser {

	void parser() {

		openFile();

		// CSV specific parsing logic
		System.out.println("parsing a CSV file");

		closeFile();
	}

	private void openFile() {
		System.out.println("Opening a file");
	}

	private void closeFile() {
		System.out.println("Closing a file");
	}

}

//JSON parser
class JSONParser {

	void parser() {

		openFile();

		// JSON specific parsing logic
		System.out.println("parsing a JSON file");

		closeFile();
	}

	private void openFile() {
		System.out.println("Opening a file");
	}

	private void closeFile() {
		System.out.println("Closing a file");
	}

}

public class WithoutTemplateMethod {

	public static void main(String[] args) {

		CSVParser csvParser = new CSVParser();
		JSONParser jsonParser = new JSONParser();
		csvParser.parser();
		jsonParser.parser();
	}
}
