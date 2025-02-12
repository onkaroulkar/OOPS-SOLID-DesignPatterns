package org.onkar.DesignPattern.MediatorPatternSolution;

import java.util.ArrayList;
import java.util.List;

interface ChatMediator{
	void sendMessages();
	void addUser(User user);
}

class ChatRoom implements ChatMediator{ 
	
	private List<User> users;
	
	void ChatRoom() {
		this.users = new ArrayList<>(); 
	}

	@Override
	public void sendMessages() {
		
		
	}

	@Override
	public void addUser(User user) {
	
		users.add(user); 	
	}
	
}

class User {

	private String name;

	public User(String string) {
		this.name = string;
	}

	public void sendMessage(String msg, User receipient) {
		System.out.println(this.name + "Sending message " + msg);
	}

	public String getaName() {
		return name;
	}
}

public class WithMediatorPattern {

	public static void main(String[] args) {
		 

	}

}
