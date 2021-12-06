package de.marcnow.coronaService;

/**
* The dataService class has instances of the country class and the Incidence class and gets the Covid Data from them. In its methods the data gets rearranged
* into the wanted data. 
* @version 1.0
*/

public class DataService {

	private Country johnHopkins;
	private Incidence robertKoch;
	
	/**
	 * This constructor creates one instance of the JohnHopkins class and one instance of the RobertKoch class to retrieve the covid informations.
	 * @throws Exception
	 */
	public DataService() throws Exception {
		JohnHopkins jh = new JohnHopkins();
		RobertKoch rk = new RobertKoch();
		
		johnHopkins = jh.getCountry();
		robertKoch = rk.getIncidence();
	}
	
	/**
	 * @return returns the new infections of the last 24 hours
	 */
	public int getNewInfections() {
		return (johnHopkins.getGermany().get((johnHopkins.getGermany().size()) - 1).getConfirmed()) 
				- johnHopkins.getGermany().get((johnHopkins.getGermany().size()) - 2).getConfirmed();
	}
	
	/**
	 * @return returns the total infections
	 */
	public int getTotalInfections() {
		return ((johnHopkins.getGermany().get((johnHopkins.getGermany().size()) - 1).getConfirmed()) 
				   - (johnHopkins.getGermany().get((johnHopkins.getGermany().size()) - 1).getRecovered()));
	}
	
	/**
	 * @return returns the infection rise of the last 24 hours
	 */
	public int getInfectionRise() {
		return ((johnHopkins.getGermany().get((johnHopkins.getGermany().size()) - 1).getConfirmed()) 
			   - (johnHopkins.getGermany().get((johnHopkins.getGermany().size()) - 1).getRecovered()))
					- ((johnHopkins.getGermany().get((johnHopkins.getGermany().size()) - 2).getConfirmed())
					- (johnHopkins.getGermany().get((johnHopkins.getGermany().size()) - 2).getRecovered()));
	}
	
	/**
	 * @return returns the infection rise of the last n days
	 * @param the parameter days represents the timespan of which the average infection rise is calculated
	 */
	public float getAverageInfectionRise(int days) {
		float averageInfectionRise = 0;
		
		for(int i = 0; i < days; i++) {
			averageInfectionRise += ((johnHopkins.getGermany().get((johnHopkins.getGermany().size()) - (i + 1)).getConfirmed()) 
									- (johnHopkins.getGermany().get((johnHopkins.getGermany().size()) - (i + 1)).getRecovered()))
										- ((johnHopkins.getGermany().get((johnHopkins.getGermany().size()) - (i + 2)).getConfirmed()) 
										- (johnHopkins.getGermany().get((johnHopkins.getGermany().size()) - (i + 2)).getRecovered()));
		}
		return averageInfectionRise / days;
	}
	
	/**
	 * @return returns the incidents value
	 */
	public float getIncidenceValue() {
		float incidenceValue = 0;
		
		for(int i = 0; i < robertKoch.getFeatures().size(); i++) {
			incidenceValue += robertKoch.getFeatures().get(i).getAttributes().getCases7_bl_per_100k();
		}
		
		return incidenceValue / robertKoch.getFeatures().size();
	}
	
	/**
	 * @return returns the target for total infections
	 */
	public float getTargetTotalInfections() { 
		return (getTotalInfections() / getIncidenceValue()) * 35;
	}
	
	/**
	 * This method returns the days the lockdown will last. If we have a positive infection rise the method will return 0.
	 * For the average infection rise we chose 7 days so a clear trend is recognizable.
	 * @return returns the estimated days the lockdown will last
	 */
	public float getDaysOfLockdown() {
		if(getAverageInfectionRise(7) > 0) {
			return 0;
		} else {
			return ((getTotalInfections() - getTargetTotalInfections()) / getAverageInfectionRise(7)) * -1;
		}
	}
}
