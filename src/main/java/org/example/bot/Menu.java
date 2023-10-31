package org.example.bot;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    protected String message;
    protected InlineKeyboardMarkup inlineKeyboardMarkup;

    public Menu() {
        this.message = "Здравствуйте \n" +
                "Это ваш дохтур и здесь вы можете найти классные рекомендации написанные мной для вашего удобства\uD83C\uDF83";

        this.initKeyboard();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private void initKeyboard() {
        inlineKeyboardMarkup = new InlineKeyboardMarkup();

        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();

        InlineKeyboardButton button = new InlineKeyboardButton();
        button.setText("Рекомендации");
        button.setCallbackData("Вызывает рекомендацию");

        ArrayList<InlineKeyboardButton> row = new ArrayList<>();
        row.add(button);
        keyboard.add(row);

        inlineKeyboardMarkup.setKeyboard(keyboard);
    }

    public InlineKeyboardMarkup getInlineKeyboardMarkup() {
        return inlineKeyboardMarkup;
    }
}
