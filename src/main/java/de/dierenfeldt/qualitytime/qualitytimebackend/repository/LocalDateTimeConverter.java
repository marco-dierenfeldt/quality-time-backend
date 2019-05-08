package de.dierenfeldt.qualitytime.qualitytimebackend.repository;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.sql.Date;
import java.time.LocalDateTime;

@Converter(autoApply = true)
public class LocalDateTimeConverter implements AttributeConverter<LocalDateTime, Date> {

    @Override
    public java.sql.Date convertToDatabaseColumn(java.time.LocalDateTime attribute) {
        return attribute == null ? null : java.sql.Date.valueOf(attribute.toLocalDate());
    }

    @Override
    public java.time.LocalDateTime convertToEntityAttribute(java.sql.Date dbData) {
        return dbData == null ? null : LocalDateTime.from(dbData.toLocalDate());
    }

}
