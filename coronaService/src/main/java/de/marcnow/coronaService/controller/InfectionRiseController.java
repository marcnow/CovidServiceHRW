package de.marcnow.coronaService.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import de.marcnow.coronaService.DataService;

/**
 * This is a class to map the data to json
 */
class InfectionRise {
	int infectionRise;
	public InfectionRise(int infectionRise) {this.infectionRise = infectionRise;}
}

/**
* handles the http requests for the rest webservice regarding the infection rise in comparison with yesterday and returns the data in json format
* @version 1.0
*/
@RestController
public class InfectionRiseController {
	
	/**
	 * This method invokes when /rest/infectionrise is called
	 * @return the infection rise of the last 24 hours
	 * @throws Exception
	 */
	@GetMapping("rest/infectionrise")
	public String infectionRise() throws Exception {
		Gson gson = new Gson();
		return gson.toJson(new InfectionRise(new DataService().getInfectionRise()));
	}
	
}
