package org.example;

import org.example.bot.Bot;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.io.IOException;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws TelegramApiException, IOException {
        try {
            TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
            telegramBotsApi.registerBot(new Bot());
            logger.trace("This is INFO");
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}