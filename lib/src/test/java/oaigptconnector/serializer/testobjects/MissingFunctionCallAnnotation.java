package oaigptconnector.serializer.testobjects;

import com.oaigptconnector.model.JSONSchemaParameter;

public class MissingFunctionCallAnnotation {

    @JSONSchemaParameter()
    private String baseString;

    @JSONSchemaParameter()
    private Integer baseInteger;

    public MissingFunctionCallAnnotation() {

    }

    public MissingFunctionCallAnnotation(String baseString, Integer baseInteger) {
        this.baseString = baseString;
        this.baseInteger = baseInteger;
    }

    public String getBaseString() {
        return baseString;
    }

    public Integer getBaseInteger() {
        return baseInteger;
    }

}
