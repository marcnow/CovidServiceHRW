package de.marcnow.coronaService.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
* handles the http requests for the rest webservice when the service is first approached
* @version 1.0
*/

@RestController
public class GreetingController {
	
	/**
	 * This method invokes when the web service is called
	 * @return a basic string with all web services
	 * @throws Exception
	 */
	@GetMapping("/")
	public String greeting() throws Exception {
		return "<h1>Corona Service API</h1>\n"
				+ "<i>Das System bereitet die Daten der John Hopkins Universität und des Robert Koch Instituts auf "
				+ "und berechnet Kennzahlen in Bezug zu Corona Situation in Deutschland. Die Daten werden sowohl über eine SOAP,"
				+ " als auch eine REST Schnittstelle, im JSON Format dem Telegram Bot HRWGruppe6_Herbert zur Verfügung gestellt.</i>\n"
				+ "Für die verfügbaren Befehle bitte /swagger-ui.html aufrufen.";
	}
}
