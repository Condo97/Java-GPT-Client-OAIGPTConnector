package com.oaigptconnector.model.fcobjects.ifcobject;

import com.oaigptconnector.model.FCTypes;

public class FCNumber implements IFCObject {

    private final FCTypes type = FCTypes.NUMBER;
    private String description;

    public FCNumber(String description) {
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
        return "FCNumber{" +
                "type=" + type +
                ", description='" + description + '\'' +
                '}';
    }

}
