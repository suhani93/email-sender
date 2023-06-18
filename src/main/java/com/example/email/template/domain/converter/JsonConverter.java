package com.example.email.template.domain.converter;

import com.fasterxml.jackson.databind.ObjectMapper;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import lombok.SneakyThrows;
import org.springframework.core.GenericTypeResolver;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

@Converter
public class JsonConverter<T> implements AttributeConverter<T, String> {

    private static final ObjectMapper objectMapper;

    @Override
    public String convertToDatabaseColumn(T attribute) {
        if (ObjectUtils.isEmpty(attribute)) {
            return null;
        }
        try {
            return objectMapper.writeValueAsString(attribute);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @SneakyThrows
    @Override
    public T convertToEntityAttribute(String dbData) {
        if (StringUtils.hasText(dbData)) {
            Class<?> aClass = GenericTypeResolver.resolveTypeArgument(getClass(), JsonConverter.class);
            return (T) objectMapper.readValue(dbData, aClass);
        }
        return null;
    }

    static{
        objectMapper = new ObjectMapper();
    }
}