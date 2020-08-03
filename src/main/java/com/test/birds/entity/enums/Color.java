package com.test.birds.entity.enums;

import java.util.Arrays;
import java.util.StringJoiner;

public enum Color {
    BLACK ("black"),
    WHITE ("white"),
    BLACK_WHITE ("black & white"),
    GREY ("grey"),
    RED ("red"),
    RED_WHITE ("red & white");

    private String color;

    Color(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

public static Color getColors(String color) {
    for (Color env : values()) {
        if (env.getColor().equals(color)) {
            return env;
        }
    }
    throw new IllegalArgumentException("No enum found with colors: [" + color + "]");
}

    @Override
    public String toString() {
        return new StringJoiner(", ", Color.class.getSimpleName() + "[", "]")
                .add("color='" + color + "'")
                .toString();
    }
}
