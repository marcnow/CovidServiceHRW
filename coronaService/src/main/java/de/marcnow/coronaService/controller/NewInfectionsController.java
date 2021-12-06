package de.marcnow.coronaService.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import de.marcnow.coronaService.DataService;



/**
 * This is a class to map the data to json
 *
 */
class NewInfections {
	int newInfections;
	public NewInfections(int newInfections) {this.newInfections = newInfections;}
}

/**
* handles the http requests for the rest webservice regarding the new infections in comparison with yesterday and returns the data in json format
* @version 1.0
*/
@RestController
public class NewInfectionsController {
	
	/**
	 * This method invokes when /rest/newinfections is called
	 * @return the new infections of the last 24 hours
	 * @throws Exception
	 */
	@GetMapping("rest/newinfections")
	public String newInfections() throws Exception {
		Gson gson = new Gson();
		return gson.toJson(new NewInfections(new DataService().getNewInfections()));
	}
}