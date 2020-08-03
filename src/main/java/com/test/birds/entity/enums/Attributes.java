package com.test.birds.entity.enums;

public enum Attributes {
    SPECIES ("species"),
    NAME ("name"),
    COLOR ("color"),
    BODY_LENGTH("body_length"),
    WINGSPAN("wingspan");

    private String attribute;

    Attributes(String attribute) {
        this.attribute = attribute;
    }

    public String getAttribute() {
        return attribute;
    }

    public static Attributes getAttributes(String attribute) {
        for (Attributes env : values()) {
            if (env.getAttribute().equals(attribute)) {
                return env;
            }
        }
        throw new IllegalArgumentException("No attribute found with attribute: [" + attribute + "]");
    }
}
