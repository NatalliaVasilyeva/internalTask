package com.test.birds.entity.enums;

import java.util.StringJoiner;

public enum Species {
    PIGEON ("pigeon"),
    SPARROW ("sparrow"),
    MAGPIE ("magpie"),
    CROW ("crow"),
    TITMOUSE ("titmouse"),
    RED_WHITE ("red & white");

    private String species;

    Species(String species) {
        this.species = species;
    }

    public String getSpecies() {
        return species;
    }

    public static Species getSpeciess(String species) {
        for (Species env : values()) {
            if (env.getSpecies().equals(species)) {
                return env;
            }
        }
        throw new IllegalArgumentException("No enum found with species: [" + species + "]");
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Species.class.getSimpleName() + "[", "]")
                .add("species='" + species + "'")
                .toString();
    }
}
