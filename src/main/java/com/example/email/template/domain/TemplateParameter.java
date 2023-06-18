package com.example.email.template.domain;

import com.example.email.template.domain.converter.JsonConverter;
import java.util.List;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode
public class TemplateParameter {
    private String name;
    private String description;
    private Object defaultValue;

    public static class TemplateParameterConverter extends JsonConverter<TemplateParameter> {}
    public static class TemplateParametersConverter extends JsonConverter<List<TemplateParameter>> {}
}
