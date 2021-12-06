package de.marcnow.coronaService.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import de.marcnow.coronaService.DataService;

/**
 * This is a class to map the data to json
 *
 */
class TotalInfections {
	int totalInfections;
	public TotalInfections(int totalInfections) {this.totalInfections = totalInfections;}
}

/**
* handles the http requests for the rest webservice regarding the total infections and returns the data in json format
* @version 1.0
*/
@RestController
public class TotalInfectionsController {
	
	/**
	 * This method invokes when /rest/totalinfections is called
	 * @return the total infections in germany
	 * @throws Exception
	 */
	@GetMapping("rest/totalinfections") 
	public String totalInfections() throws Exception {
		Gson gson = new Gson();
		return gson.toJson(new TotalInfections(new DataService().getTotalInfections()));
	}
}
