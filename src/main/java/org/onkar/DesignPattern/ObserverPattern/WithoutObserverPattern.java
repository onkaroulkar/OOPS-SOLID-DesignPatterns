package org.onkar.DesignPattern.ObserverPattern;

class DisplayDevice {
	public void showTemp(float temp) {
		System.out.println("current temp: " + temp + "C");
	}
}

class WeatherStation {

	private float temperature;
	private DisplayDevice displayDevice;// can be multiple devices later.

	public WeatherStation(DisplayDevice desplayDevice) {
		this.displayDevice = desplayDevice;
	}

	public void setTemperature(float temp) {
		this.temperature = temp;
		notifyDevice();
	}

	public void notifyDevice() {
		displayDevice.showTemp(temperature);
	}
}

public class WithoutObserverPattern {

	public static void main(String[] args) {

		DisplayDevice displayDevice = new DisplayDevice();
		WeatherStation weatherStation = new WeatherStation(displayDevice);

		// tight coupling between station and device.
		weatherStation.setTemperature(16.12f);
		weatherStation.setTemperature(23.34f);

	}
}
