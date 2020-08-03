package com.test.birds.converter;

import com.test.birds.entity.enums.Species;

import java.beans.PropertyEditorSupport;

public class SpeciesEnumConverter extends PropertyEditorSupport {

    public void setAsText(final String text) throws IllegalArgumentException {
        setValue(Species.getSpeciess(text));
    }
}
