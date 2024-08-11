package com.oaigptconnector.model.jsonschema.isobase;

import com.oaigptconnector.model.jsonschema.JSONSchemaObject;

public class SOBase implements ISOBase {

    private String name;
    private String description;
    private JSONSchemaObject schema;
    private Boolean strict;

    public SOBase(String name, String description, JSONSchemaObject schema, Boolean strict) {
        this.name = name;
        this.description = description;
        this.strict = strict;
        this.schema = schema;
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
    public JSONSchemaObject getSchema() {
        return schema;
    }

    @Override
    public Boolean getStrict() {
        return strict;
    }

}
