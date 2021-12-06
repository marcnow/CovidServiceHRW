package de.marcnow.coronaService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

/**
* CoronaServiceApplication starts the telegram bot and the spring application.
* @version 1.0
*/
@SpringBootApplication
public class CoronaServiceApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(CoronaServiceApplication.class, args);
		
		try {
			TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
            telegramBotsApi.registerBot(new Herbert_Bot());
            System.out.println("Telegramm-Bot gestartet...");
            
        } catch (TelegramApiException e) {
        	e.printStackTrace();
        }
        
	}
}
