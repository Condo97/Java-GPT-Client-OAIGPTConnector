package com.oaigptconnector.model.jsonschema;

import com.oaigptconnector.model.JSONSchemaTypes;

public class JSONSchemaBoolean implements IJSONSchemaObject {

    private final JSONSchemaTypes type = JSONSchemaTypes.BOOLEAN;
    private String description;

    public JSONSchemaBoolean(String description) {
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
        return "FCBoolean{" +
                "type=" + type +
                ", description='" + description + '\'' +
                '}';
    }

}
