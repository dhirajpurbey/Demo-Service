package com.stackroute.plasma.GoogleResponseModel;

public class Context {
    private String title;


    // Getter Methods

    public String getTitle() {
        return title;
    }

    // Setter Methods

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Context{" +
                "title='" + title + '\'' +
                '}';
    }
}