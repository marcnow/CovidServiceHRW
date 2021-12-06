package de.marcnow.coronaService;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import com.google.gson.Gson;

/**
* The Herbert_Bot class implements the telegram bot and communicates with telegram and our webservice
* @version 1.0
*/
public class Herbert_Bot extends TelegramLongPollingBot {
	
	 /**
	  * This method decides which indicator the bot prints out depending on the command the user puts in
	 * @param gets triggered when the user communicates with the bot and answers with the covid data received by the webservice
	 */ 
	public void onUpdateReceived(Update update) {
						 
		String command = update.getMessage().getText();
		SendMessage message = new SendMessage();
		
		Gson gson = new Gson();
		CovidKeyIndicators covidKeyIndicators = new CovidKeyIndicators();
		String json = null;
		try {
			json = readUrl("https://coronaservice-grp6.herokuapp.com/rest/all");
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		covidKeyIndicators = gson.fromJson(json, CovidKeyIndicators.class);
		
		if(command.equals("/start")) {
			message.setText("Hallo ich bin Herbert, der von den Studenten der HRW programmierte Bot, �ber den man die aktuellen Corona Kennzahlen in Deutschland beziehen kann. Wie kann ich Ihnen weiterhelfen?");
		}
		else if(command.equals("/neuinfektionen")) {
			message.setText("Von gestern auf heute haben sich " + covidKeyIndicators.getNewInfections() + " Leute neu mit Corona infiziert.");
		}	
		else if(command.equals("/gesamtinfektionen")) {
			message.setText("Zurzeit haben wir " + covidKeyIndicators.getTotalInfections() + " Gesamtinfektionen.");
		}		
		else if(command.equals("/anstieg")) {
			message.setText("In Gesamtdeutschland haben wir " + covidKeyIndicators.getInfectionRise() + " Infizierte zum Vortag.");
		}
		else if(command.startsWith("/durchschnittlicheranstieg")) {
			if(command.equals("/durchschnittlicheranstieg")) {
				if(covidKeyIndicators.getAverageInfectionRise() > 0) {
					message.setText("Der durchschnittliche Anstieg der Infizierten der letzten 3 Tage " + covidKeyIndicators.getAverageInfectionRise() + "\n" +
							"Für einen anderen Parameter bitte hinter dem Befehl angeben, Beispiel: /durchschnittlicheranstieg5");
				} else {
					message.setText("Der durchschnittliche Abstieg der Infizierten der letzten 3 Tage " + covidKeyIndicators.getAverageInfectionRise() + "\n" +
							"Für einen anderen Parameter bitte hinter dem Befehl angeben, Beispiel: /durchschnittlicheranstieg5");
				}
			} else {
				String days = command.substring(26, command.length());
				String tmp = null;
				try {
					if(Integer.parseInt(days) <= 0) {
						message.setText("Ungültiger Paramter: negative Zahl oder 0 nicht erlaubt!");
					} else {
						tmp = readUrl("https://coronaservice-grp6.herokuapp.com/rest/averageinfectionrise?days=" + days);
					
						AverageInfectionRise averageInfectionRise = new AverageInfectionRise();
						averageInfectionRise = gson.fromJson(tmp, AverageInfectionRise.class);
						if(averageInfectionRise.getAverageInfectionRise() > 0) {
							message.setText("Der durchschnittliche Anstieg der Infizierten der letzten " + days + " Tage beträgt: " + averageInfectionRise.getAverageInfectionRise());
						} else {
							message.setText("Der durchschnittliche Abstieg der Infizierten der letzten " + days + " Tage beträgt: " + averageInfectionRise.getAverageInfectionRise());
						}
					}
				} catch (NumberFormatException e) {
					message.setText("Ungültiger Paramter: Bitte eine gültige Zahl eingeben!");
				} catch (IOException e) {
					message.setText("Ungültiger Paramter: zu große Zahl!");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		else if(command.equals("/rwert")) {
			message.setText("Der Inzidenz-Wert für Gesamtdeutschland beträgt " + covidKeyIndicators.getIncidenceValue() + "!");
		}
		else if(command.equals("/zielgesamtinfektionen")) {
			message.setText("Die Ziel-Gesamtinfektion lautet " + covidKeyIndicators.getTargetTotalInfections() + "!");
		}
		else if(command.equals("/voraussage")) {
			if(covidKeyIndicators.getDaysOfLockdown() == 0) {
				message.setText("Über die Vorraussage kann gerade keine Aussage getroffen werden, da die Infiziertenrate nicht sinkt.");
			} else {
				message.setText("Vorraussichtlich dauert der Lockdown noch ca. " + (int) covidKeyIndicators.getDaysOfLockdown() + " Tage");
			}
		} else {
			message.setText("Bitte einen gültigen Befehl angeben!");
		}
			
		message.setChatId(update.getMessage().getChatId().toString());
			
		if(message.getText()!=null) {
			try {
				execute(message);
			} catch (TelegramApiException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * @param the parameter urlString contains the http adress for the covid data from our web service
	 * @return returns the data converted into json String
	 * @throws Exception when an error in the BufferedReader occurs
	 */
	private static String readUrl(String urlString) throws Exception {
		BufferedReader reader = null;
		try {
			URL url = new URL(urlString);
		    reader = new BufferedReader(new InputStreamReader(url.openStream()));
		    StringBuffer buffer = new StringBuffer();
		    int read;
		    char[] chars = new char[1024];
		    while ((read = reader.read(chars)) != -1) {
		        buffer.append(chars, 0, read);
		    }
		    return buffer.toString();
		    } finally {
		    	if (reader != null) {
		    		reader.close();
		    	}
		    }
		}
		
	public String getBotUsername() {
		return "HRWGruppe6_Herbert_Bot";
	}
	
	@Override
	public String getBotToken() {
		return "1617533748:AAHNMwFsp17gySJwEsxewNYhlJV76ARgKiI";
	}
}
