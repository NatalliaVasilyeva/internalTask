

package com.test.birds.converter;

import com.test.birds.entity.enums.Color;
import com.test.birds.entity.enums.Species;
import jdk.jfr.Configuration;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.type.EnumType;
import org.hibernate.usertype.DynamicParameterizedType;
import org.hibernate.usertype.UserType;
import org.springframework.stereotype.Component;


import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Properties;


@Component
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

