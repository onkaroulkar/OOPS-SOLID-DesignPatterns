package org.onkar.DesignPattern.BuilderPattern;

public class Home {

	private String foundation;
	private String structure;
	private String roof;
	private boolean hasGarage;
	private boolean hasSwimmingPool;
	private boolean hasGarden;

	// constructor
	private Home(HouseBuilder houseBuilder) {
		this.foundation = houseBuilder.foundation;
		this.structure = houseBuilder.structure;
		this.roof = houseBuilder.roof;
		this.hasGarage = houseBuilder.hasGarage;
		this.hasSwimmingPool = houseBuilder.hasSwimmingPool;
		this.hasGarden = houseBuilder.hasGarden;
	}

	@Override
	public String toString() {
		return "Home [foundation=" + foundation + ", structure=" + structure + ", roof=" + roof + ", hasGarage="
				+ hasGarage + ", hasSwimmingPool=" + hasSwimmingPool + ", hasGarden=" + hasGarden + "]";
	}

	public static class HouseBuilder {

		private String foundation;
		private String structure;
		private String roof;
		private boolean hasGarage;
		private boolean hasSwimmingPool;
		private boolean hasGarden;

		// Builder constructor with mandatory parameters
		public HouseBuilder(String foundation, String structure, String roof) {
			this.foundation = foundation;
			this.structure = structure;
			this.roof = roof;
		}

		// Optional Parameters
		public HouseBuilder setGarage(boolean hasGarage) {
			this.hasGarage = hasGarage;
			return this;
		}

		public HouseBuilder setSwimmingPool(boolean hasSwimmingPool) {
			this.hasSwimmingPool = hasSwimmingPool;
			return this;
		}

		public HouseBuilder setGarden(boolean hasGarden) {
			this.hasGarden = hasGarden;
			return this;
		}

		public Home Build() {
			return new Home(this);
		}
	}
}
