package com.test.birds.converter;

import com.test.birds.entity.enums.Color;
import org.springframework.stereotype.Component;

import java.beans.PropertyEditorSupport;


@Component
public class ColorEnumConverter extends PropertyEditorSupport {

    public void setAsText(final String text) throws IllegalArgumentException {
        setValue(Color.getColors(text));
    }
}
