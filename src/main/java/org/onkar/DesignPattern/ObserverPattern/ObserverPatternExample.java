package org.onkar.DesignPattern.ObserverPattern;

import java.util.ArrayList;
import java.util.List;

// Observer Interface
interface Observer {
	void update(float temp);
}

// Subject interface 
interface Subject {
	void attach(Observer obs);

	void detach(Observer obs);

	void notifyObservers();
}

// Weather Station 
class WeatherStationIn implements Subject {

	private float temperature;
	private List<Observer> observerList;

	public void setTemperature(float temperature) {
		this.temperature = temperature;
		notifyObservers();
	}

	public WeatherStationIn() {
		observerList = new ArrayList<>();
	}

	@Override
	public void attach(Observer obs) {
		observerList.add(obs);
	}

	@Override
	public void detach(Observer obs) {
		observerList.remove(obs);
	}

	@Override
	public void notifyObservers() {

		for (Observer obs : observerList) {
			obs.update(temperature); // Run time polymorphism.
		}
	}
}

class DisplayDeviceIn implements Observer {

	private String name;

	public DisplayDeviceIn(String deviceName) {
		this.name = deviceName;
	}

	@Override
	public void update(float temp) {
		System.out.println("Tempetarure on " + name + " is " + temp);

	}

}

class MobileDevice implements Observer {

	private String name;

	public MobileDevice(String mobileName) {
		this.name = mobileName;
	}

	@Override
	public void update(float temp) {
		System.out.println("Temp on " + name + " is " + temp);
	}

}

public class ObserverPatternExample {

	public static void main(String[] args) {
		// Create a publisher
		WeatherStationIn we = new WeatherStationIn();
		DisplayDeviceIn dd = new DisplayDeviceIn("Samsung");
		MobileDevice md = new MobileDevice("Nokia");

		we.attach(dd);
		we.attach(md);
		we.setTemperature(23);
		we.setTemperature(24);
	}
}
