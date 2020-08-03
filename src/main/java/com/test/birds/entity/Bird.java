package com.test.birds.entity;

import com.test.birds.converter.ColorConverter;
import com.test.birds.converter.SpeciesConverter;
import com.test.birds.entity.enums.Color;
import com.test.birds.entity.enums.Species;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnTransformer;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;


import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name="birds")

public class Bird {

    @Id
    @Column(name = "name", nullable = false)
//    @NotEmpty (message = "Provide name of bird")
    private String name;

    @Convert(converter = ColorConverter.class)
    @Column(columnDefinition="bird_color")
    @ColumnTransformer(write="?::bird_color")
    private Color color;

    @Convert(converter = SpeciesConverter.class)
    @Column(columnDefinition="bird_species")
    @ColumnTransformer(write="?::bird_species")
    private Species species;

//    @NotNull
    @Min(value = 0, message = "Provide body length without negative value")
    private int body_length;

//    @NotNull
    @Min(value = 0, message = "Provide wingspan without negative value")
    private int wingspan;
}
