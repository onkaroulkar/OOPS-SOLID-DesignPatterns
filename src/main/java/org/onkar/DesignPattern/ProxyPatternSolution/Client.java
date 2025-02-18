package org.onkar.DesignPattern.ProxyPatternSolution;

public class Client {

	public static void main(String[] args) {
		Image img1 = new ProxyImage("dog.png");
		Image img2 = new ProxyImage("dog.png");
		img1.display();
		img1.display();
	}
}
