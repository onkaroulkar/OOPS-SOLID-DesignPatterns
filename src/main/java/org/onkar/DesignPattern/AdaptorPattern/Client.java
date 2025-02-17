package org.onkar.DesignPattern.AdaptorPattern;

public class Client {

	public static void main(String[] args) {
		
		NotificationService emailService = new EmailNotificationService();
		emailService.send("fujitsu.com", "Sick leave", "I want leave.");
		
		NotificationService sendGridEmailService = new SendGridAdapter(new SendGridService());
		sendGridEmailService.send("oulkar.com", "Marrage Leave", "I want to get married");
	}
}
