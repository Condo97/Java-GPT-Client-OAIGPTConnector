package com.oaigptconnector.model.jsonschema;

import com.oaigptconnector.model.JSONSchemaTypes;

public class JSONSchemaArray implements IJSONSchemaObject {

    private final JSONSchemaTypes type = JSONSchemaTypes.ARRAY;
    private String description;
    private IJSONSchemaObject items;

    public JSONSchemaArray() {

    }

    public JSONSchemaArray(String description, IJSONSchemaObject items) {
        this.description = description;
        this.items = items;
    }

    @Override
    public JSONSchemaTypes getType() {
        return type;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public IJSONSchemaObject getItems() {
        return items;
    }


    @Override
    public String toString() {
        return "FCArray{" +
                "type=" + type +
                ", description='" + description + '\'' +
                ", items=" + items +
                '}';
    }

}
