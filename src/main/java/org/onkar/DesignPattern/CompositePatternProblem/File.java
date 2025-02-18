package org.onkar.DesignPattern.CompositePatternProblem;

public class File {
	private String name;
	
	public File(String name) {
		this.name = name;
	}
	
	public void showDetails() {
		System.out.println("File: "+ name);
	}
}
