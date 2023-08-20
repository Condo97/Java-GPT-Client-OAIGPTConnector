package com.oaigptconnector.model.fcobjects.ifcobject;

import com.oaigptconnector.model.FCTypes;

public class FCInteger implements IFCObject {

    private final FCTypes type = FCTypes.INTEGER;
    private String description;

    public FCInteger(String description) {
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
        return "FCInteger{" +
                "type=" + type +
                ", description='" + description + '\'' +
                '}';
    }

}
