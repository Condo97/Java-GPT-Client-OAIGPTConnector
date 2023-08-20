package com.oaigptconnector.model.fcobjects.ifcobject;

import com.oaigptconnector.model.FCTypes;

import java.util.List;

public class FCArray implements IFCObject {

    private final FCTypes type = FCTypes.ARRAY;
    private String description;
    private IFCObject items;

    public FCArray() {

    }

    public FCArray(String description, IFCObject items) {
        this.description = description;
        this.items = items;
    }

    @Override
    public FCTypes getType() {
        return type;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public IFCObject getItems() {
        return items;
    }


    @Override
    public String toString() {
        return "FCArray{" +
                "type=" + type +
                ", description='" + description + '\'' +
                ", items=" + items +
                '}';
    }

}
