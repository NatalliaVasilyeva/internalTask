package com.test.birds.validation;

import com.test.birds.entity.Bird;
import com.test.birds.entity.enums.Attributes;
import com.test.birds.entity.enums.Color;
import com.test.birds.entity.enums.Species;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Stream;


@Service
public class ValidateParameters {


    public void validateAttribute(String attribute) {
        Attributes.getAttributes(attribute.toLowerCase());
    }

    public void validateTypeOfSort(String typeOfSort) {
      if(!(typeOfSort.equals("asc") || typeOfSort.equals("desc"))){
          throw new IllegalArgumentException("No type of sort found with attribute: [" + typeOfSort + "]");
      }
    }

    public List<String> validateRequestBody(Bird bird) {
        String name = bird.getName();
        Color color = bird.getColor();
        Species species = bird.getSpecies();
        Integer body_length = bird.getBody_length();
        Integer wingspan = bird.getWingspan();

        List<String> errors = new ArrayList<>();
        Map<String, String> hashMap = new HashMap<>();

        hashMap.put("name", name);
        hashMap.put("color", color.getColor());
        hashMap.put("species", species.getSpecies());
        hashMap.put("body_length", body_length.toString());
        hashMap.put("wingspan", wingspan.toString());


        for(Map.Entry<String, String> entry: hashMap.entrySet()) {
            if(entry.getValue()==null||entry.getValue().isBlank()) {
                errors.add(String.format("Attribute %s can not be null", entry.getKey()));
            }
        }
    return errors;
    }

}

