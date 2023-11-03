package org.example.bot;

public class ConfigBot {
    protected final String botToken;
    protected final String botName;

    public ConfigBot() {
        this.botToken = "6541493813:AAHBa1UqjKh51UabBbvkFWGkYWKP2L8SKj4";
        this.botName = "DocTur";
    }

    public String getBotToken() {
        return botToken;
    }

    public String getBotName() {
        return botName;
    }
}
