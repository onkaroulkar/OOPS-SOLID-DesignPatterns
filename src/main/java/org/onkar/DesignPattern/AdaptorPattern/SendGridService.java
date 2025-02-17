package org.onkar.DesignPattern.AdaptorPattern;

public class SendGridService {
	
	public void sendEmail(String recipient, String title, String content) {
		System.out.println("Sending email via SendGrid to "+ recipient);
		System.out.println("Title: "+ recipient);
		System.out.println("Content: "+ content);
	}
}
