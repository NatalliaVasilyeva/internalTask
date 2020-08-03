package com.test.birds.entity;

import com.test.birds.converter.ColorConverter;
import com.test.birds.converter.SpeciesConverter;
import com.test.birds.entity.enums.Color;
import com.test.birds.entity.enums.Species;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;


import javax.persistence.*;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name="birds")

public class Bird {

    @Id
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "color")
    @Convert(converter = ColorConverter.class)
    private Color color;
    @Column(name = "species")
    @Convert(converter = SpeciesConverter.class)
    private Species species;
    private int body_length;
    private int wingspan;
}
