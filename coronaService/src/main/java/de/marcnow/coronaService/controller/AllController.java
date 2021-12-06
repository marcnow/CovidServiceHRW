package de.marcnow.coronaService.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import de.marcnow.coronaService.CovidKeyIndicators;
import de.marcnow.coronaService.DataService;

/**
* handles the http requests for the rest webservice regarding the all covid key indicators and returns the data in json format
* @version 1.0
*/

@RestController
public class AllController {
	
	/**
	 * This method invokes when /rest/all is called
	 * @param days, the default value is 3
	 * @return covidKeyIndicators in a json format
	 * @throws Exception
	 */
	@GetMapping("/rest/all")
	public String covidKeyIndicators(@RequestParam(value = "days", defaultValue = "3") int days) throws Exception {
		Gson gson = new Gson();
		DataService ds = new DataService();
		return gson.toJson(new CovidKeyIndicators(ds.getNewInfections(), ds.getTotalInfections(), ds.getInfectionRise(), ds.getAverageInfectionRise(days),
				ds.getIncidenceValue(), ds.getTargetTotalInfections(), ds.getDaysOfLockdown()));
	}
}
