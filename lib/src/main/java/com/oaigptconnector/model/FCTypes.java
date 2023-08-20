package com.oaigptconnector.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum FCTypes {

    OBJECT("object"),
    ARRAY("array"),
    INTEGER("integer"),
    NUMBER("number"),
    BOOLEAN("boolean"),
    STRING("string");

    private String stringValue;

    FCTypes(String stringValue) {
        this.stringValue = stringValue;
    }

    public static FCTypes fromString(String string) {
        for (FCTypes fcType: FCTypes.values())
            if (fcType.getStringValue().equals(string))
                return fcType;

        return null;
    }

    @JsonValue
    public String getStringValue() {
        return stringValue;
    }

}
