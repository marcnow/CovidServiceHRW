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
class TargetTotalInfections {
	float targetTotalInfections;
	public TargetTotalInfections(float targetTotalInfections) {this.targetTotalInfections = targetTotalInfections;}
}

/**
* handles the http requests for the soap webservice regarding the target for total infections and returns the data in json format
* @author Marc Nowakowski
* @version 1.0
*/
@RestController
public class TargetTotalInfectionsSoapController {
	
	/**
	 * This method invokes when /soap/targettotalinfections is called
	 * @return the target total infections
	 * @throws Exception
	 */
	@GetMapping("soap/targettotalinfections")
	public String targetTotalInfections() throws Exception {
		CovidKeyIndicatorsEndpoint endpoint = new CovidKeyIndicatorsEndpoint();
		GetCovidKeyIndicatorsRequest request = new GetCovidKeyIndicatorsRequest();
		GetCovidKeyIndicatorsResponse response = endpoint.getCovidKeyIndicators(request);
		
		Gson gson = new Gson();
		
		return gson.toJson(new TargetTotalInfections(response.getCovidKeyIndicators().getTargetTotalInfections()));
	}

}
