package com.belatrixsf.accessibilityexamples.model;

/**
 * Created by eduardomedina on 16/09/16.
 */
public class Field {

    private int id;
    private FormType type;
    private String description;
    private String value;

    public Field() {
    }

    public Field(int id, FormType type, String description, String value) {
        this.id = id;
        this.type = type;
        this.description = description;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public FormType getType() {
        return type;
    }

    public void setType(FormType type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
