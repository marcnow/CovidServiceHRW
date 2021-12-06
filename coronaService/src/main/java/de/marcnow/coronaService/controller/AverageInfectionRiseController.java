package de.marcnow.coronaService.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import de.marcnow.coronaService.DataService;


/**
 * This is a class to map the data to json
 *
 */
class AverageInfectionRise {
	float averageInfectionRise;
	public AverageInfectionRise(float averageInfectionRise) {this.averageInfectionRise = averageInfectionRise;}
}

/**
* handles the http requests for the rest webservice regarding the average infection rise and returns the data in json format
* @version 1.0
*/
@RestController
public class AverageInfectionRiseController {
	
	/**
	 * This method invokes when /rest/averageinfectionrise is called
	 * @param days, the default value is 3
	 * @return the average infection of the last n days
	 * @throws Exception
	 */
	@GetMapping("rest/averageinfectionrise")
	public String averageInfectionRise(@RequestParam(value = "days", defaultValue = "3") int days) throws Exception {
		Gson gson = new Gson();
		return gson.toJson(new AverageInfectionRise(new DataService().getAverageInfectionRise(days)));
	}
	
}
