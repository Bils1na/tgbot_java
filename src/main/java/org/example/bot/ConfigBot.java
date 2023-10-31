package org.example.bot;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;

public class ConfigBot {
    protected final String botToken;
    protected final String botName;
    protected ReplyKeyboardMarkup replyKeyboardMarkup;

    public ConfigBot(String token, String name) {
        this.botToken = token;
        this.botName = name;
        this.initKeyboard();
    }

    private void initKeyboard() {
        //Создаем объект будущей клавиатуры и выставляем нужные настройки
        replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setResizeKeyboard(true); // подгоняем размер
        replyKeyboardMarkup.setOneTimeKeyboard(true); //скрываем после использования

        // Создаем список с рядами кнопок
        ArrayList<KeyboardRow> keyboardRows = new ArrayList<>();
        // Создаем один ряд кнопок и добавляем его в список
        KeyboardRow keyboardRow = new KeyboardRow();
        keyboardRows.add(keyboardRow);
        //Добавляем одну кнопку с текстом "Просвяти" наш ряд
        keyboardRow.add(new KeyboardButton("Вызвать меню"));
        //добавляем лист с одним рядом кнопок в главный объект
        replyKeyboardMarkup.setKeyboard(keyboardRows);
    }

}
