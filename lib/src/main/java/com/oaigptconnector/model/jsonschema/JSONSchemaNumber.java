package com.oaigptconnector.model.jsonschema;

import com.oaigptconnector.model.JSONSchemaTypes;

public class JSONSchemaNumber implements IJSONSchemaObject {

    private final JSONSchemaTypes type = JSONSchemaTypes.NUMBER;
    private String description;

    public JSONSchemaNumber(String description) {
        this.description = description;
    }

    @Override
    public JSONSchemaTypes getType() {
        return type;
    }

    @Override
    public String getDescription() {
        return description;
    }


    @Override
    public String toString() {
        return "FCNumber{" +
                "type=" + type +
                ", description='" + description + '\'' +
                '}';
    }

}
