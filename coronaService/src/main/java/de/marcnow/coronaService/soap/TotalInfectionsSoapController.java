package de.marcnow.coronaService.soap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import coronaservice_grp6.GetCovidKeyIndicatorsRequest;
import coronaservice_grp6.GetCovidKeyIndicatorsResponse;

/**
 * This is a class to map the data to json
 * @author Marc Nowakowski
 *
 */
class TotalInfections {
	int totalInfections;
	public TotalInfections(int totalInfections) {this.totalInfections = totalInfections;}
}

/**
* handles the http requests for the soap webservice regarding the total infections and returns the data in json format
* @author Marc Nowakowski
* @version 1.0
*/
@RestController
public class TotalInfectionsSoapController {
	
	/**
	 * This method invokes when /soap/totalinfections is called
	 * @return the total infections in germany
	 * @throws Exception
	 */
	@GetMapping("soap/totalinfections") 
	public String totalInfections() throws Exception {
		CovidKeyIndicatorsEndpoint endpoint = new CovidKeyIndicatorsEndpoint();
		GetCovidKeyIndicatorsRequest request = new GetCovidKeyIndicatorsRequest();
		GetCovidKeyIndicatorsResponse response = endpoint.getCovidKeyIndicators(request);
		
		Gson gson = new Gson();
		
		return gson.toJson(new TotalInfections(response.getCovidKeyIndicators().getTotalInfections()));
	}
}
