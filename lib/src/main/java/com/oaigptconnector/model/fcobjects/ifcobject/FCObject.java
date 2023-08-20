package com.oaigptconnector.model.fcobjects.ifcobject;

import com.oaigptconnector.model.FCTypes;

import java.util.List;
import java.util.Map;

public class FCObject implements IFCObject {

    private final FCTypes type = FCTypes.OBJECT;
    private String description;
    private Map<String, IFCObject> properties;
    private List<String> required;

    public FCObject() {

    }

    public FCObject(String description, Map<String, IFCObject> properties, List<String> required) {
        this.description = description;
        this.properties = properties;
        this.required = required;
    }

    @Override
    public FCTypes getType() {
        return type;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public Map<String, IFCObject> getProperties() {
        return properties;
    }

    public List<String> getRequired() {
        return required;
    }


    @Override
    public String toString() {
        return "FCObject{" +
                "type=" + type +
                ", description='" + description + '\'' +
                ", properties=" + properties +
                ", required=" + required +
                '}';
    }

}
