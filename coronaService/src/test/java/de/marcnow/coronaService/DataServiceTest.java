package de.marcnow.coronaService;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DataServiceTest {
	
	private DataService dataService;
	
	@BeforeEach
	void setup() throws Exception{
		dataService = mock(DataService.class);
	}

	//Da die Daten sich regelmäßig ändern müssen die Testdaten vor dem Test angepasst werden,
	//der Test überprüft dann die Korrektheit der Rechnung
	
	@Test
	void getNewInfectionsTest() {
		float infections = 4838;
		assertEquals(infections, dataService.getNewInfections());
	}
	
	@Test
	void getTotalInfectionsTest() {
		int totalInfections = 204811;
		assertEquals(totalInfections, dataService.getTotalInfections());
	}
	
	@Test
	void getInfectionRiseTest() {
		int infectionRise = -4093;
		assertEquals(infectionRise, dataService.getInfectionRise());
	}
	
	@Test
	void getAverageInfectionRiseTest() {
		int days = 5;
		float averageInfectionRise = (float) -3054.8;
		assertEquals(averageInfectionRise, dataService.getAverageInfectionRise(days));
	}
	
	@Test
	void getIncidenceValueTest() {
		float incidenceValue = (float) 63.985237;
		assertEquals(incidenceValue, dataService.getIncidenceValue());
	}
	
	@Test
	void getTargetTotalInfectionsTest() {
		float targetTotalInfections = (float) 112031.86;
		assertEquals(targetTotalInfections, dataService.getTargetTotalInfections());
	}
	
	@Test
	void getDaysofLockdownTest() {
		float daysOfLockdown = (float) 18.986551;
		assertEquals(daysOfLockdown, dataService.getDaysOfLockdown());
	}
}
