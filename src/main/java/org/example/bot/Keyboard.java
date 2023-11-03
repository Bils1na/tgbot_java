package org.example.bot;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

public class Keyboard {
    protected ReplyKeyboardMarkup chatButtons;
    protected InlineKeyboardMarkup messageButtons;

    public Keyboard() {
        this.initChatButtons();
        this.initMessageButtons();
    }


    private void initChatButtons() {
        chatButtons = new ReplyKeyboardMarkup();
        chatButtons.setResizeKeyboard(true); // подгоняем размер
        chatButtons.setOneTimeKeyboard(false); //скрываем после использования

        ArrayList<KeyboardRow> keyboardRows = new ArrayList<>();
        KeyboardRow keyboardRow = new KeyboardRow();
        keyboardRows.add(keyboardRow);
        keyboardRow.add("Вызвать меню");

        chatButtons.setKeyboard(keyboardRows);
    }

    public ReplyKeyboardMarkup getChatButtons() {
            return chatButtons;
        }

    private void initMessageButtons() {
        messageButtons = new InlineKeyboardMarkup();

        List<List<InlineKeyboardButton>> buttons = new ArrayList<>();
        InlineKeyboardButton button = new InlineKeyboardButton();
        button.setText("Рекомендации");
        button.setCallbackData("Вызывает рекомендацию");
        ArrayList<InlineKeyboardButton> row = new ArrayList<>();
        row.add(button);
        buttons.add(row);

        messageButtons.setKeyboard(buttons);
    }

    public InlineKeyboardMarkup getMessageButtons() {
        return messageButtons;
    } 
}