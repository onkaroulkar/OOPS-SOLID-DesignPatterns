 package org.onkar.DesignPattern.StatePattern.Solution;

public class Walking implements TransportationMode  {

	@Override
	public int calsETA() {
		
		System.out.println("Calculatin ETA(Walking)");
		return 10;
	}

	@Override
	public String getDirection() {
		  
		return  "Directon for walking" ;
	}
	
}
  