package com.epam.jwd.task3.entities;

public class Attribute {
    private String key;
    private Object value;

    public Attribute(String key, Object value) {
        this.key = key;
        this.value = value;
    }


    @Override
    public String toString() {
        return key + " = " + value.toString();
    }
}
