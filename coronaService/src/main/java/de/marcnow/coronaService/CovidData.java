package de.marcnow.coronaService;

/**
* The CovidData class provides a construct for the Country class but is never used itself.
* @version 1.0
*/

public class CovidData {
	
	private String date;
    private int confirmed;
    private int deaths;
    private int recovered;
    
    public CovidData() {
    }
    
	public CovidData(String date, int confirmed, int deaths, int recovered) {
		this.date = date;
		this.confirmed = confirmed;
		this.deaths = deaths;
		this.recovered = recovered;
	}

	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getConfirmed() {
		return confirmed;
	}
	public void setConfirmed(int confirmed) {
		this.confirmed = confirmed;
	}
	public int getDeaths() {
		return deaths;
	}
	public void setDeaths(int deaths) {
		this.deaths = deaths;
	}
	public int getRecovered() {
		return recovered;
	}
	public void setRecovered(int recovered) {
		this.recovered = recovered;
	}
}
