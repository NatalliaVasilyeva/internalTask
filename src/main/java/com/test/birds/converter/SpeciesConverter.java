package com.test.birds.converter;

import com.test.birds.entity.enums.Species;


import javax.persistence.AttributeConverter;
import javax.persistence.Converter;


@Converter
public class SpeciesConverter implements AttributeConverter<Species, String> {
    @Override
    public String convertToDatabaseColumn(Species species) {
        return species.getSpecies();
    }
    @Override
    public Species convertToEntityAttribute(String  dbData) {
        System.out.println(dbData);
        return Species.getSpeciess(dbData);
    }
}

