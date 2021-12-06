package de.marcnow.coronaService.soap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import coronaservice_grp6.GetCovidKeyIndicatorsRequest;
import coronaservice_grp6.GetCovidKeyIndicatorsResponse;


/**
 * This is a class to map the data to json
 * @author Till von Seggern
 */
class NewInfections {
	int newInfections;
	public NewInfections(int newInfections) {this.newInfections = newInfections;}
}

/**
* handles the http requests for the soap webservice regarding the new infections in comparison with yesterday and returns the data in json format
* @author Till von Seggern
* @version 1.0
*/
@RestController
public class NewInfectionsSoapController {
	
	/**
	 * This method invokes when /soap/newinfections is called
	 * @return the new infections of the last 24 hours
	 * @throws Exception
	 */
	@GetMapping("soap/newinfections")
	public String newInfections() throws Exception {
		CovidKeyIndicatorsEndpoint endpoint = new CovidKeyIndicatorsEndpoint();
		GetCovidKeyIndicatorsRequest request = new GetCovidKeyIndicatorsRequest();
		GetCovidKeyIndicatorsResponse response = endpoint.getCovidKeyIndicators(request);
		
		Gson gson = new Gson();
		
		return gson.toJson(new NewInfections(response.getCovidKeyIndicators().getNewInfections()));
	}
}