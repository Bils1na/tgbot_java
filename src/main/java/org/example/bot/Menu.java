package org.example.bot;

public class Menu {
    protected String message;

    public Menu() {
        this.message = "Здравствуйте \n" +
                "Это ваш дохтур и здесь вы можете найти классные рекомендации написанные мной для вашего удобства\uD83C\uDF83";
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
