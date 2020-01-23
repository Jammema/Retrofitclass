package com.example.retrofitclass.model;

public class Design {
    private int scenery;
    private String text;

    public Design(int scenery, String text) {
        this.scenery = scenery;
        this.text = text;
    }

    public int getScenery() {
        return scenery;
    }

    public void setScenery(int scenery) {
        this.scenery = scenery;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
