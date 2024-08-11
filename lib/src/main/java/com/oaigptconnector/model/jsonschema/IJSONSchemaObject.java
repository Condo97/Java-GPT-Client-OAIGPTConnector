package com.oaigptconnector.model.jsonschema;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.oaigptconnector.model.JSONSchemaTypes;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public interface IJSONSchemaObject {

    JSONSchemaTypes getType();
    String getDescription();

}
