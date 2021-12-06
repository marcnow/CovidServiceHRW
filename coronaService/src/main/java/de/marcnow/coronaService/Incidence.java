package de.marcnow.coronaService;

import java.util.List;

/**
* gets data from RobertKoch class 
* @version 1.0
*/

public class Incidence extends Feature {
	
	public Incidence() {
	}
	
	private List<Feature> features;

	public List<Feature> getFeatures() {
		return features;
	}

	public void setFeatures(List<Feature> features) {
		this.features = features;
	}
}
