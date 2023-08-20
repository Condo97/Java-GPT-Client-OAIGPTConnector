package com.oaigptconnector.model.fcobjects.ifcbase;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.oaigptconnector.model.fcobjects.ifcobject.FCObject;
import com.oaigptconnector.model.fcobjects.ifcobject.IFCObject;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public interface IFCBase {

    /***
     * The base function call
     *
     * name - Required, used as the name of the function
     * description - Optional, used as the description of the function
     * parameters - Required, must be FCObject here, used as the base description of the function call's parameters
     */

    String getName();
    String getDescription();
    FCObject getParameters();

}
