package de.marcnow.coronaService.soap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import coronaservice_grp6.GetCovidKeyIndicatorsRequest;
import coronaservice_grp6.GetCovidKeyIndicatorsResponse;


/**
 * This is a class to map the data to json
 * @author Niklas Frochte
 *
 */
class AverageInfectionRise {
	float averageInfectionRise;
	public AverageInfectionRise(float averageInfectionRise) {this.averageInfectionRise = averageInfectionRise;}
}

/**
* handles the http requests for the soap webservice regarding the average infection rise and returns the data in json format
* @author Niklas Frochte
* @version 1.0
*/
@RestController
public class AverageInfectionRiseSoapController {
	
	/**
	 * This method invokes when /soap/averageinfectionrise is called
	 * @param days, the default value is 3
	 * @return the average infection of the last n days
	 * @throws Exception
	 */
	@GetMapping("soap/averageinfectionrise")
	public String averageInfectionRise(@RequestParam(value = "days", defaultValue = "3") int days) throws Exception {
		CovidKeyIndicatorsEndpoint endpoint = new CovidKeyIndicatorsEndpoint();
		GetCovidKeyIndicatorsRequest request = new GetCovidKeyIndicatorsRequest();
		request.setDays(days);
		GetCovidKeyIndicatorsResponse response = endpoint.getCovidKeyIndicators(request);
		
		Gson gson = new Gson();
		
		return gson.toJson(new AverageInfectionRise(response.getCovidKeyIndicators().getAverageInfectionRise()));
	}
	
}
