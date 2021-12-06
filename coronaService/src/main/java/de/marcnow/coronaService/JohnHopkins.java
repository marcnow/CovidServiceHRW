package de.marcnow.coronaService;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import com.google.gson.Gson;

/**
* reads data from the John Hopkins University represented by the URL and parses them from json to country class
* @version 1.0
*/

public class JohnHopkins extends Country {
	
	private Country country;
	
	/**
	 * uses the readURL method to get the covid data in json format and converts to country class
	 * @throws Exception
	 */
	public JohnHopkins() throws Exception {
		
		String json = readUrl("https://pomber.github.io/" + "covid19/timeseries.json");
		
		Gson gson = new Gson();
		country = gson.fromJson(json, Country.class);
	}
	
	/**
	 * @param the parameter urlString contains the http adress for the covid data from the John Hopkins University
	 * @return returns the data converted into json String
	 * @throws Exception when an error in the BufferedReader occurs
	 */
	private static String readUrl(String urlString) throws Exception {
		BufferedReader reader = null;
	    try {
	        URL url = new URL(urlString);
	        reader = new BufferedReader(new InputStreamReader(url.openStream()));
	        StringBuffer buffer = new StringBuffer();
	        int read;
	        char[] chars = new char[1024];
	        while ((read = reader.read(chars)) != -1) {
	        	buffer.append(chars, 0, read);
	        }
	        return buffer.toString();
	        
	    } finally {
	        if (reader != null)
	            reader.close();
	    }
	}
	
	public Country getCountry() {
		return country;
	}
	
	public void setCountry(Country country) {
		this.country = country;
	}
}
