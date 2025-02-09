package org.onkar.SOLIDPrinciples.DIP.GoodCode;

public class main {

	public static void main(String[] args) {
		NotificationService emailService = new NotificationService(new EmailService());
		emailService.notify("20000 send successfully");
		
		NotificationService smsService = new NotificationService(new SMSService());
		smsService.notify("50000 send successfully");
}
}
