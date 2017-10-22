package workingbot;

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;

public class MyMain {

    public static void main(String[] args) {

        ApiContextInitializer.init();


        TelegramBotsApi botsApi = new TelegramBotsApi();

        // Register our bot
        try {
            botsApi.registerBot(new AlitiaMyTestCode());
            //new LettoreRSS("http://www.ansa.it/sito/ansait_rss.xml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
