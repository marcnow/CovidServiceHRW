package de.marcnow.coronaService;


/**
* This is a class to map the json data to the class
* @version 1.0
*/
public class AverageInfectionRise {
	private float averageInfectionRise;
	
	public AverageInfectionRise(float averageInfectionRise) {
		this.averageInfectionRise = averageInfectionRise;
	}
	
	public AverageInfectionRise() {
	}

	public float getAverageInfectionRise() {
		return averageInfectionRise;
	}

	public void setAverageInfectionRise(float averageInfectionRise) {
		this.averageInfectionRise = averageInfectionRise;
	}
	
	
	
}