package de.marcnow.coronaService.soap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import coronaservice_grp6.GetCovidKeyIndicatorsRequest;
import coronaservice_grp6.GetCovidKeyIndicatorsResponse;

/**
 * This is a class to map the data to json
 * @author Björn Bulenda
 *
 */
class IncidenceValue {
	float incidenceValue;
	public IncidenceValue(float incidenceValue) {this.incidenceValue = incidenceValue;}
}

/**
* handles the http requests for the soap webservice regarding the incidence value and returns the data in json format
* @author Björn Bulenda
* @version 1.0
*/
@RestController
public class IncidenceValueSoapController {
	
	/**
	 * This method invokes when /soap/incidencevalue is called
	 * @return the incidence value of germany 
	 * @throws Exception
	 */
	@GetMapping("soap/incidencevalue")
	public String incidenceValue() throws Exception {
		CovidKeyIndicatorsEndpoint endpoint = new CovidKeyIndicatorsEndpoint();
		GetCovidKeyIndicatorsRequest request = new GetCovidKeyIndicatorsRequest();
		GetCovidKeyIndicatorsResponse response = endpoint.getCovidKeyIndicators(request);
		
		Gson gson = new Gson();
		
		return gson.toJson(new IncidenceValue(response.getCovidKeyIndicators().getIncidenceValue()));
	}
}
