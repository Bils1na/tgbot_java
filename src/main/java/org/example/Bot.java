package org.example;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class Bot extends TelegramLongPollingBot {
    private final String BOT_TOKEN = "6541493813:AAHBa1UqjKh51UabBbvkFWGkYWKP2L8SKj4";
    private final String BOT_NAME = "DocTur";
    Storage storage;

    Bot(){
        storage = new Storage();
    }

    @Override
    public String getBotUsername() {
        return BOT_NAME;
    }

    @Override
    public String getBotToken() {
        return BOT_TOKEN;
    }

    @Override
    public void onUpdateReceived(Update update) {
        try {
            if (update.hasMessage() && update.getMessage().hasText()) {
                //Извлекаем из объекта сообщение пользователя
                Message msg = update.getMessage();
                //Достаем из msg id чата пользователя
                String chatId = msg.getChatId().toString();
                //Получаем текст сообщения пользователя, отправляем в написанный нами обработчик
                String response = parseMessage(msg.getText());
                //Создаем объект класса SendMessage - наш будущий ответ пользователю
                SendMessage answer = new SendMessage();

                //Добавляем в наше сообщение id чата а также наш ответ
                answer.setChatId(chatId);
                answer.setText(response);

                //Отправка в чат
                execute(answer);
            }
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public String parseMessage(String text) {
        String response;

        //Сравниваем текст пользователя с нашими командами, на основе этого формируем ответ
        if (text.equals("/start")) {
            response = "Hello Vitalik cocet xyu";
        } else if (text.equals("/get")) {
            response = storage.getRandQuote();
        } else {
            response = "Error";
        }

        return response;
    }
}
