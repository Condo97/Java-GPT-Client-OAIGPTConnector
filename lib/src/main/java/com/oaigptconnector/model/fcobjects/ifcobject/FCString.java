package com.oaigptconnector.model.fcobjects.ifcobject;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.oaigptconnector.model.FCTypes;

import java.util.Arrays;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class FCString implements IFCObject {

    private final FCTypes type = FCTypes.STRING;
    private String description;
    @JsonProperty("enum")
    private String[] stringEnumValues;

    public FCString() {

    }

    public FCString(String description, String[] stringEnumValues) {
        this.description = description;
        this.stringEnumValues = stringEnumValues;
    }

    @Override
    public FCTypes getType() {
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
