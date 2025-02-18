package org.onkar.DesignPattern.ProxyPatternSolution;

public class ProxyImage implements Image {
	
	private String filename;
	
	// Proxy reference to real Image
	private RealImage realImage;
	
	public ProxyImage(String filename) {
		this.filename = filename;
	}
	@Override
	public void display() {
		 if(realImage == null) {
			 realImage = new RealImage(filename);
		 }
		 realImage.display();
	}
}
