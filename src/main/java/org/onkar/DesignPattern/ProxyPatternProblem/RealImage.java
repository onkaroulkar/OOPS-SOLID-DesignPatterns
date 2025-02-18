package org.onkar.DesignPattern.ProxyPatternProblem;

public class RealImage implements Image {

	private String filename;

	public RealImage(String filename) {
		this.filename = filename;
		loadImageFromDisk(); // Expensive Operation.
	}

	public void loadImageFromDisk() {
		System.out.println("Loading image from a disk " + filename);
	}

	@Override
	public void display() {
		System.out.println("Displaying: " + filename);
	}
}
