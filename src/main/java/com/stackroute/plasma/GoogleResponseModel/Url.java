package com.stackroute.plasma.GoogleResponseModel;

public class Url {
    private String type;
    private String template;


    // Getter Methods

    public String getType() {
        return type;
    }

    public String getTemplate() {
        return template;
    }

    // Setter Methods

    public void setType(String type) {
        this.type = type;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    @Override
    public String toString() {
        return "Url{" +
                "type='" + type + '\'' +
                ", template='" + template + '\'' +
                '}';
    }
}