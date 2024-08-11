package com.oaigptconnector.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum JSONSchemaTypes {

    OBJECT("object"),
    ARRAY("array"),
    INTEGER("integer"),
    NUMBER("number"),
    BOOLEAN("boolean"),
    STRING("string");

    private String stringValue;

    JSONSchemaTypes(String stringValue) {
        this.stringValue = stringValue;
    }

    public static JSONSchemaTypes fromString(String string) {
        for (JSONSchemaTypes fcType: JSONSchemaTypes.values())
            if (fcType.getStringValue().equals(string))
                return fcType;

        return null;
    }

    @JsonValue
    public String getStringValue() {
        return stringValue;
    }

}
