package org.onkar.DesignPattern.ProxyPatternProblem;

public class Client {

	public static void main(String[] args) {
		Image img = new RealImage("dog.png");
		Image img2 = new RealImage("dog.png");
	}
}
