package com.oaigptconnector.model.jsonschema;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.oaigptconnector.model.JSONSchemaTypes;

import java.util.Arrays;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class JSONSchemaString implements IJSONSchemaObject {

    private final JSONSchemaTypes type = JSONSchemaTypes.STRING;
    private String description;
    @JsonProperty("enum")
    private String[] stringEnumValues;

    public JSONSchemaString() {

    }

    public JSONSchemaString(String description, String[] stringEnumValues) {
        this.description = description;
        this.stringEnumValues = stringEnumValues;
    }

    @Override
    public JSONSchemaTypes getType() {
        return type;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public String[] getStringEnumValues() {
        return stringEnumValues;
    }

    @Override
    public String toString() {
        return "FCString{" +
                "type=" + type +
                ", description='" + description + '\'' +
                ", stringEnumValues=" + Arrays.toString(stringEnumValues) +
                '}';
    }

}
