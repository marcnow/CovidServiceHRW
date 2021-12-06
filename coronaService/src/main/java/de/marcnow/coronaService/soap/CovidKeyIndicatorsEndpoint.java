package de.marcnow.coronaService.soap;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import coronaservice_grp6.CovidKeyIndicators;
import coronaservice_grp6.GetCovidKeyIndicatorsRequest;
import coronaservice_grp6.GetCovidKeyIndicatorsResponse;
import de.marcnow.coronaService.DataService;

/**
* This class retrieves the data via soap
* @author Niklas Frochte
* @author Marc Nowakowski
* @version 1.0
*/
@Endpoint
public class CovidKeyIndicatorsEndpoint {
	

	@PayloadRoot(namespace = "coronaservice-grp6", localPart = "getNewInfectionsRequest")
	@ResponsePayload
	/**
	 * 
	 * @param request
	 * @return the class covidKeyIndicators with live indicators
	 * @throws Exception
	 */
	public GetCovidKeyIndicatorsResponse getCovidKeyIndicators(@RequestPayload GetCovidKeyIndicatorsRequest request) throws Exception {
		
		GetCovidKeyIndicatorsResponse response = new GetCovidKeyIndicatorsResponse();
		DataService ds = new DataService();
		
		CovidKeyIndicators covidKeyIndicators = new CovidKeyIndicators();
		covidKeyIndicators.setNewInfections(ds.getNewInfections());
		covidKeyIndicators.setTotalInfections(ds.getTotalInfections());
		covidKeyIndicators.setInfectionRise(ds.getInfectionRise());
		covidKeyIndicators.setAverageInfectionRise(ds.getAverageInfectionRise(request.getDays()));
		covidKeyIndicators.setIncidenceValue(ds.getIncidenceValue());
		covidKeyIndicators.setTargetTotalInfections(ds.getTargetTotalInfections());
		covidKeyIndicators.setDaysOfLockdown(ds.getDaysOfLockdown());
		
		response.setCovidKeyIndicators(covidKeyIndicators);
		
		return response;
	}
	
}
