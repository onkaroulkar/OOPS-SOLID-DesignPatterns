package org.onkar.SOLIDPrinciples.DIP.BadCode;

public class main {

	public static void main(String[] args) {
		NotificationService notificationService = new NotificationService();
		notificationService.notifyByEmail("100 rupees send");
		notificationService.notifyBySMS("2000 rupees send");
	}
}
