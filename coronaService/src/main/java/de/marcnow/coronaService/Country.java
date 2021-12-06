package de.marcnow.coronaService;

import java.util.List;

/**
* The country class gets the data for germany from the johnHopkins class and provides these for the dataService class.
* @version 1.0
*/

public class Country extends CovidData {
	
	private String countryName = "Germany";
    private List<CovidData> Germany;
    
    public Country() {
    }
    
	public Country(String countryName, List<CovidData> germany) {
		this.countryName = countryName;
		Germany = germany;
	}

	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public List<CovidData> getGermany() {
		return Germany;
	}
	public void setGermany(List<CovidData> germany) {
		Germany = germany;
	}
}
