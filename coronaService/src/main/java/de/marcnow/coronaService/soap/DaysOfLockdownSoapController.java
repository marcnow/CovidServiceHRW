package de.marcnow.coronaService.soap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import coronaservice_grp6.GetCovidKeyIndicatorsRequest;
import coronaservice_grp6.GetCovidKeyIndicatorsResponse;

/**
 * This is a class to map the data to json
 * @author Niklas Frochte
 */
class DaysOfLockdown {
	float daysOfLockdown;
	public DaysOfLockdown(float daysOfLockdown) {this.daysOfLockdown = daysOfLockdown;}
}

/**
* handles the http requests for the soap webservice regarding the estimated amount of days in the lockdown and returns the data in json format
* @author Niklas Frochte
* @version 1.0
*/
@RestController
public class DaysOfLockdownSoapController {
	
	/**
	 * This method invokes when /soap/daysoflockdown is called
	 * @return the estimated days of lockdown
	 * @throws Exception
	 */
	@GetMapping("soap/daysoflockdown")
	public String daysOfLockdown() throws Exception {
		CovidKeyIndicatorsEndpoint endpoint = new CovidKeyIndicatorsEndpoint();
		GetCovidKeyIndicatorsRequest request = new GetCovidKeyIndicatorsRequest();
		GetCovidKeyIndicatorsResponse response = endpoint.getCovidKeyIndicators(request);
		
		Gson gson = new Gson();
		
		return gson.toJson(new DaysOfLockdown(response.getCovidKeyIndicators().getDaysOfLockdown()));
	}
}
