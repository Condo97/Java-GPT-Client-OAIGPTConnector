package com.oaigptconnector.model.jsonschema.ifcbase;

import com.oaigptconnector.model.jsonschema.JSONSchemaObject;
import com.oaigptconnector.model.jsonschema.isobase.ISOBase;

public class FCBase implements IFCBase {

    private String name;
    private String description;
    private JSONSchemaObject parameters;
    private Boolean strict;

    public FCBase(String name, String description, JSONSchemaObject parameters, Boolean strict) {
        this.name = name;
        this.description = description;
        this.strict = strict;
        this.parameters = parameters;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public JSONSchemaObject getParameters() {
        return parameters;
    }

    @Override
    public Boolean getStrict() {
        return strict;
    }

}
