package org.example.bot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;


public class Bot extends TelegramLongPollingBot {
    private final ConfigBot config;
    Storage storage;
    Menu menu;


    public Bot(){
        config = new ConfigBot(
                "6541493813:AAHBa1UqjKh51UabBbvkFWGkYWKP2L8SKj4",
                "DocTur"
        );
        storage = new Storage();
        menu = new Menu();
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
                //Извлекаем из объекта сообщение пользователя
                Message msg = update.getMessage();
                //Достаем из msg id чата пользователя
                String chatId = msg.getChatId().toString();
                //Создаем объект класса SendMessage - наш будущий ответ пользователю
                SendMessage answer = new SendMessage();
                parseMessage(msg.getText(), answer);

                //Добавляем в наше сообщение id чата а также наш ответ
                answer.setChatId(chatId);


                //Отправка в чат
                execute(answer);
            }
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private void parseMessage(String text, SendMessage answer) {
        String response;

        //Сравниваем текст пользователя с нашими командами, на основе этого формируем ответ
        if (text.equals("/menu")) {
             answer.setText(menu.getMessage());
             answer.setReplyMarkup(menu.getInlineKeyboardMarkup());
        }   else if (text.equals("Вызвать меню")){
            answer.setText(menu.getMessage());
            answer.setReplyMarkup(menu.getInlineKeyboardMarkup());
        } else {
             answer.setText("Error");
            answer.setReplyMarkup(config.replyKeyboardMarkup);
        }
    }

}
