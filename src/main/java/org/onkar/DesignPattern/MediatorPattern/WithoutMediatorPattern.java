package org.onkar.DesignPattern.MediatorPattern;

public class WithoutMediatorPattern {
	
	public static void main(String[]args) {
		
		User rahul = new User("Rahul");
		User neha = new User("Neha");
		User amit = new User("Amit");
		
		rahul.sendMessage("Hellow", amit);
		rahul.sendMessage("tu kasa ahes", neha);
		amit.sendMessage("tu khup sunder ahes", neha);
		
	}

}
