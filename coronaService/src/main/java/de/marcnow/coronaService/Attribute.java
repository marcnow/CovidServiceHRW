package de.marcnow.coronaService;

/**
* This is a class to map the RKI data to json
* @version 1.0
*/
public class Attribute {
	private float cases7_bl_per_100k;
	
	public Attribute() {
	}

	public Attribute(float cases7_bl_per_100k) {
		this.cases7_bl_per_100k = cases7_bl_per_100k;
	}

	public float getCases7_bl_per_100k() {
		return cases7_bl_per_100k;
	}

	public void setCases7_bl_per_100k(float cases7_bl_per_100k) {
		this.cases7_bl_per_100k = cases7_bl_per_100k;
	}
}
