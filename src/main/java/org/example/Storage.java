package org.example;

import java.util.ArrayList;

public class Storage {
    private ArrayList<String> quoteList;
    Storage(){
        quoteList = new ArrayList<>();
        quoteList.add("Ямиля");
        quoteList.add("Чуханян");
        quoteList.add("Чуханян");
    }

    String getRandQuote() {
        int randomQuote = (int)(Math.random() * quoteList.size());
        return quoteList.get(randomQuote);
    }
}
