package com.oaigptconnector.model.fcobjects.ifcbase;

import com.oaigptconnector.model.fcobjects.ifcobject.FCObject;

public class FCBase implements IFCBase {

    private String name;
    private String description;
    private FCObject parameters;

    public FCBase(String name, String description, FCObject parameters) {
        this.name = name;
        this.description = description;
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
    public FCObject getParameters() {
        return parameters;
    }

}
