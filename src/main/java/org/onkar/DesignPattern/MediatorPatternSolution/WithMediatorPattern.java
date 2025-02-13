
package org.onkar.DesignPattern.MediatorPatternSolution;

import java.util.ArrayList;
import java.util.List;

// Interface chatMediator
interface ChatMediator {
	void sendMessages(String msg, User user);

	void addUser(User user);
}

// class chatRoom implements chatMeadiator.
class ChatRoom implements ChatMediator {

	private List<User> users;

	public ChatRoom() {
		this.users = new ArrayList<>();
	}

	@Override
	public void sendMessages(String msg, User sender) {
		for (User user : users) {
			if (user != sender) {
				user.receiveMessage(msg, sender);
			}
		}
	}

	@Override
	public void addUser(User user) {

		users.add(user);
	}
}

// chat user class
class User {

	private String name;
	private ChatMediator chatRoom;

	public User(String string, ChatMediator chatRoom2) {
		this.name = string;
		this.chatRoom = chatRoom2;
	}

	public void sendMessage(String msg) {
		System.out.println(this.name + " Sending message: " + msg);
		chatRoom.sendMessages(msg, this);
	}

	public void receiveMessage(String msg, User sender) {
		System.out.println(this.name + " receive message: " + msg + "from " + sender.getaName());
	}

	public String getaName() {
		return name;
	}
}

public class WithMediatorPattern {

	public static void main(String[] args) {

		ChatMediator chatRoom = new ChatRoom();
		User rohit = new User("Rohit", chatRoom);
		User subha = new User("Subha", chatRoom);
		User sachin = new User("Sachin", chatRoom);

		chatRoom.addUser(sachin);
		chatRoom.addUser(subha);
		chatRoom.addUser(rohit);

		rohit.sendMessage("Hello all how are you!!");
	}
}
