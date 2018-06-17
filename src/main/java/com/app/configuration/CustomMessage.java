package com.app.configuration;

import java.io.Serializable;

public class CustomMessage implements Serializable {

    private String text;

    public CustomMessage() {
    }

    public CustomMessage(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }


    @Override
    public String toString() {
        return "CustomMessage{" +
                "text='" + text + '\'' +
                '}';
    }
}
