package de.marcnow.coronaService;

/**
* provides construct for the Incidence class
* @version 1.0
*/

public class Feature extends Attribute {
	private Attribute attributes;

	public Feature() {
	}
	
	public Attribute getAttributes() {
		return attributes;
	}

	public void setAttributes(Attribute attributes) {
		this.attributes = attributes;
	}
}
