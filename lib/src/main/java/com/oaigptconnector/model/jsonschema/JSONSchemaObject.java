package com.oaigptconnector.model.jsonschema;

import com.oaigptconnector.model.JSONSchemaTypes;

import java.util.List;
import java.util.Map;

public class JSONSchemaObject implements IJSONSchemaObject {

    private final JSONSchemaTypes type = JSONSchemaTypes.OBJECT;
    private Boolean additionalProperties; // Per Doc: controls whether it is allowable for an object to contain additional keys / values that were not defined in the JSON Schema.
    private String description;
    private Map<String, IJSONSchemaObject> properties;
    private List<String> required;

    public JSONSchemaObject() {

    }

    public JSONSchemaObject(Boolean additionalProperties, String description, Map<String, IJSONSchemaObject> properties, List<String> required) {
        this.additionalProperties = additionalProperties;
        this.description = description;
        this.properties = properties;
        this.required = required;
    }

    @Override
    public JSONSchemaTypes getType() {
        return type;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public Boolean getAdditionalProperties() {
        return additionalProperties;
    }

    public Map<String, IJSONSchemaObject> getProperties() {
        return properties;
    }

    public List<String> getRequired() {
        return required;
    }


    @Override
    public String toString() {
        return "JSONSchemaObject{" +
                "type=" + type +
                ", additionalProperties=" + additionalProperties +
                ", description='" + description + '\'' +
                ", properties=" + properties +
                ", required=" + required +
                '}';
    }

}
