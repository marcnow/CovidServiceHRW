package de.marcnow.coronaService.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import de.marcnow.coronaService.DataService;

/**
 * This is a class to map the data to json
 *
 */
class IncidenceValue {
	float incidenceValue;
	public IncidenceValue(float incidenceValue) {this.incidenceValue = incidenceValue;}
}

/**
* handles the http requests for the rest webservice regarding the incidence value and returns the data in json format
* @version 1.0
*/
@RestController
public class IncidenceValueController {
	
	/**
	 * This method invokes when /rest/incidencevalue is called
	 * @return the incidence value of germany 
	 * @throws Exception
	 */
	@GetMapping("rest/incidencevalue")
	public String incidenceValue() throws Exception {
		Gson gson = new Gson();
		return gson.toJson(new IncidenceValue(new DataService().getIncidenceValue()));
	}
}
