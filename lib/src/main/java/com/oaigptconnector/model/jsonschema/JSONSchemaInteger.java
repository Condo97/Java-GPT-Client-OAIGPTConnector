package com.oaigptconnector.model.jsonschema;

import com.oaigptconnector.model.JSONSchemaTypes;

public class JSONSchemaInteger implements IJSONSchemaObject {

    private final JSONSchemaTypes type = JSONSchemaTypes.INTEGER;
    private String description;

    public JSONSchemaInteger(String description) {
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
        return "FCInteger{" +
                "type=" + type +
                ", description='" + description + '\'' +
                '}';
    }

}
