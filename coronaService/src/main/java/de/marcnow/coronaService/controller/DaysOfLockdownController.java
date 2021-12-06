package de.marcnow.coronaService.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import de.marcnow.coronaService.DataService;

/**
 * This is a class to map the data to json
 */
class DaysOfLockdown {
	float daysOfLockdown;
	public DaysOfLockdown(float daysOfLockdown) {this.daysOfLockdown = daysOfLockdown;}
}

/**
* handles the http requests for the rest webservice regarding the estimated amount of days in the lockdown and returns the data in json format
* @author Niklas Frochte
* @version 1.0
*/
@RestController
public class DaysOfLockdownController {
	
	/**
	 * This method invokes when /rest/daysoflockdown is called
	 * @return the estimated days of lockdown
	 * @throws Exception
	 */
	@GetMapping("rest/daysoflockdown")
	public String daysOfLockdown() throws Exception {
		Gson gson = new Gson();
		return gson.toJson(new DaysOfLockdown(new DataService().getDaysOfLockdown()));
	}
}
