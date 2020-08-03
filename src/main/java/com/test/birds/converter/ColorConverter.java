package com.test.birds.converter;

import com.test.birds.entity.enums.Color;


import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class ColorConverter implements AttributeConverter<Color, String> {
    @Override
    public String convertToDatabaseColumn(Color color) {
        return color.getColor();
    }
    @Override
    public Color convertToEntityAttribute(String  dbData) {
        System.out.println(dbData);
        return Color.getColors(dbData);
    }
}

