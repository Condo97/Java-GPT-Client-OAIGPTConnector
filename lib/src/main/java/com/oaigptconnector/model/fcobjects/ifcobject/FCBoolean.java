package com.oaigptconnector.model.fcobjects.ifcobject;

import com.oaigptconnector.model.FCTypes;

public class FCBoolean implements IFCObject {

    private final FCTypes type = FCTypes.BOOLEAN;
    private String description;

    public FCBoolean(String description) {
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
        return "FCBoolean{" +
                "type=" + type +
                ", description='" + description + '\'' +
                '}';
    }

}
