package com.oaigptconnector.model.jsonschema.isobase;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.oaigptconnector.model.jsonschema.JSONSchemaObject;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public interface ISOBase {

    /***
     * The base function call
     *
     * name - Required, used as the name of the function
     * description - Optional, used as the description of the function
     * schema - Required, must be FCObject here, used as the base description of the function call's parameters
     * strict - Optional, if set to true will follow exact parameters, defaults to false
     */

    String getName();
    String getDescription();
    JSONSchemaObject getSchema();
    Boolean getStrict();

}
