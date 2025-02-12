package org.onkar.DesignPattern.MediatorPattern;

public class User {

	private String name;
	
	public User(String string) {      
		this.name = string;
	}
	
	public void sendMessage(String msg, User receipient) {
		System.out.println(this.name + "Sending message " + msg   );
	}
	
	public String getaName() {
		return name; 
	}
}
