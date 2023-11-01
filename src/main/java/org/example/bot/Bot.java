package org.example.bot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Bot extends TelegramLongPollingBot {
    private static final ConfigBot config;
    private Storage storage;
    private Menu menu;
    private SendMessage answer;
    private Keyboard keyboards;

    private static final Logger logger = LoggerFactory.getLogger(Bot.class);


    public Bot(){
        config = new ConfigBot(
                "6541493813:AAHBa1UqjKh51UabBbvkFWGkYWKP2L8SKj4",
                "DocTur"
        );
        storage = new Storage();
        menu = new Menu();
        keyboards = new Keyboard();
    }

    @Override
    public String getBotUsername() {
        return config.botName;
    }

    @Override
    public String getBotToken() {
        return config.botToken;
    }

    @Override
    public void onUpdateReceived(Update update) {
        try {
            if (update.hasMessage() && update.getMessage().hasText()) {
                Message msg = update.getMessage();
                String chatId = msg.getChatId().toString();
                answer = new SendMessage();
                parseMessage(msg.getText());

                answer.setChatId(chatId);

                execute(answer);
            }
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private void parseMessage(String text) {
        if (text.equals("/menu")) {
             answer.setText(menu.getMessage());
             answer.setReplyMarkup(keyboards.getMessageButtons());
        }   else if (text.equals("Вызвать меню")){
            answer.setText(menu.getMessage());
            answer.setReplyMarkup(keyboards.getMessageButtons());
        } else {
            answer.setText("Error");
            answer.setReplyMarkup(keyboards.getChatButtons());
        }
    }

    public boolean processTask(Task task) {
        logger.debug("processTask id =" + task.getId());
        try {
            task.start();
            task.progress();
            task.complete();
            return true;
        } catch (Exception e) {
            logger.error("Unknown error", e);
            return false;
        }
    }

}
