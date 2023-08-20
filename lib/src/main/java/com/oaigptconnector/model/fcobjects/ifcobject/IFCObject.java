package com.oaigptconnector.model.fcobjects.ifcobject;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.oaigptconnector.model.FCTypes;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public interface IFCObject {

    FCTypes getType();
    String getDescription();

}
