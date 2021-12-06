package de.marcnow.coronaService;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import com.google.gson.Gson;

/**
* reads data from the Robert Koch Institut represented by the URL and parses them from json to Incidence class
* @version 1.0
*/
public class RobertKoch extends Incidence {
	
	private Incidence incidence;
	
	/**
	 * uses the readURL method to get the covid data in json format and converts to Incidence class
	 * @throws Exception
	 */
	public RobertKoch() throws Exception {
		String json = readUrl("https://services7.arcgis.com/"
				+ "mOBPykOjAyBO2ZKk/arcgis/rest/services/Coronaf%C3%A4lle_in_den_Bundesl%C3%A4ndern"
				+ "/FeatureServer/0/query"
				+ "?where=1%3D1&outFields=cases7_bl_per_100k&returnGeometry=false&outSR=4326&f=json");
		
		Gson gson = new Gson();
		incidence = gson.fromJson(json, Incidence.class);
	}
	
	/**
	 * @param the parameter urlString contains the http adress for the covid data from the Robert Koch Institut
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
	
	public Incidence getIncidence() {
		return incidence;
	}
	
	public void setIncidence(Incidence incidence) {
		this.incidence = incidence;
	}
}
