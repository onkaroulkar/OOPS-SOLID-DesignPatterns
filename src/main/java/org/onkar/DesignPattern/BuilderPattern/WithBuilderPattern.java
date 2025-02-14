package org.onkar.DesignPattern.BuilderPattern;

public class WithBuilderPattern {

	public static void main(String[] args) {
		
		Home house = new Home.HouseBuilder("Concrete","Wooden","Tile")
											.setGarage(true)
											.setSwimmingPool(true)
											.setGarden(false)
											.Build();
		System.out.println(house);
		
	}
}
 