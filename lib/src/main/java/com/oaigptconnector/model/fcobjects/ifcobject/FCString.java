package com.oaigptconnector.model.fcobjects.ifcobject;

import com.oaigptconnector.model.FCTypes;

public class FCString implements IFCObject {

    private final FCTypes type = FCTypes.STRING;
    private String description;

    public FCString() {

    }

    public FCString(String description) {
        this.description = description;
    }

    @Override
    public FCTypes getType() {
        return type;
    }

    @Override
    public String getDescription() {
        return description;
    }


    @Override
    public String toString() {
        return "FCString{" +
                "type=" + type +
                ", description='" + description + '\'' +
                '}';
    }

}
