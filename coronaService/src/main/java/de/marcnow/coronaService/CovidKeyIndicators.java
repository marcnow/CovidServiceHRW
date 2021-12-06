package de.marcnow.coronaService;

/**
* This is a class to map json data to this class
* @version 1.0
*/
public class CovidKeyIndicators {
	private int newInfections;
	private int totalInfections;
	private int infectionRise;
	private float averageInfectionRise;
	private float incidenceValue;
	private float targetTotalInfections;
	private float daysOfLockdown;
	
	
	public CovidKeyIndicators(int newInfections, int totalInfections, int infectionRise, float averageInfectionRise,
			float incidenceValue, float targetTotalInfections, float daysOfLockdown) {
		this.newInfections = newInfections;
		this.totalInfections = totalInfections;
		this.infectionRise = infectionRise;
		this.averageInfectionRise = averageInfectionRise;
		this.incidenceValue = incidenceValue;
		this.targetTotalInfections = targetTotalInfections;
		this.daysOfLockdown = daysOfLockdown;
	}

	public CovidKeyIndicators() {
	}

	public int getNewInfections() {
		return newInfections;
	}


	public void setNewInfections(int newInfections) {
		this.newInfections = newInfections;
	}


	public int getTotalInfections() {
		return totalInfections;
	}


	public void setTotalInfections(int totalInfections) {
		this.totalInfections = totalInfections;
	}


	public int getInfectionRise() {
		return infectionRise;
	}


	public void setInfectionRise(int infectionRise) {
		this.infectionRise = infectionRise;
	}


	public float getAverageInfectionRise() {
		return averageInfectionRise;
	}


	public void setAverageInfectionRise(float averageInfectionRise) {
		this.averageInfectionRise = averageInfectionRise;
	}


	public float getIncidenceValue() {
		return incidenceValue;
	}


	public void setIncidenceValue(float incidenceValue) {
		this.incidenceValue = incidenceValue;
	}


	public float getTargetTotalInfections() {
		return targetTotalInfections;
	}


	public void setTargetTotalInfections(float targetTotalInfections) {
		this.targetTotalInfections = targetTotalInfections;
	}


	public float getDaysOfLockdown() {
		return daysOfLockdown;
	}


	public void setDaysOfLockdown(float daysOfLockdown) {
		this.daysOfLockdown = daysOfLockdown;
	}
	
	
}
