package com.maytic.SpringPortfolioApp.entity;

/**
 * simple mail object for sending mail
 */
public class Mail {
    private String from;
    private String text;
    private String name;

    public Mail(){}
    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Mail{" +
                "from='" + from + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
