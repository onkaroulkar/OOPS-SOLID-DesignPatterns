package org.onkar.SOLIDPrinciples.DIP.GoodCode;

public class SMSService implements NotificationChannel{

	@Override
	public void send(String sms) {
		System.out.println("Sending SMS: "  + sms);
	}
}
