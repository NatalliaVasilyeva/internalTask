package com.test.birds.converter;

import com.test.birds.entity.enums.Color;
import org.springframework.stereotype.Component;


import javax.persistence.AttributeConverter;


@Component
public class ColorConverter implements AttributeConverter<Color, String> {
    @Override
    public String convertToDatabaseColumn(Color color) {
        return color.getColor();
    }

    @Override
    public Color convertToEntityAttribute(String dbData) {
        return Color.getColors(dbData);
    }
}

