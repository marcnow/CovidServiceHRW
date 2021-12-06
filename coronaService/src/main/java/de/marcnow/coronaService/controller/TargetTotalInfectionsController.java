package de.marcnow.coronaService.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import de.marcnow.coronaService.DataService;

/**
 * This is a class to map the data to json
 *
 */
class TargetTotalInfections {
	float targetTotalInfections;
	public TargetTotalInfections(float targetTotalInfections) {this.targetTotalInfections = targetTotalInfections;}
}

/**
* handles the http requests for the rest webservice regarding the target for total infections and returns the data in json format
* @version 1.0
*/
@RestController
public class TargetTotalInfectionsController {
	
	/**
	 * This method invokes when /rest/targettotalinfections is called
	 * @return the target total infections
	 * @throws Exception
	 */
	@GetMapping("rest/targettotalinfections")
	public String targetTotalInfections() throws Exception {
		Gson gson = new Gson();
		return gson.toJson(new TargetTotalInfections(new DataService().getTargetTotalInfections()));
	}

}
