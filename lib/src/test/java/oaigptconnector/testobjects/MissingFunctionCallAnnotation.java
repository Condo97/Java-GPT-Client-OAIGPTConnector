package oaigptconnector.testobjects;

import com.oaigptconnector.model.FCParameter;

public class MissingFunctionCallAnnotation {

    @FCParameter()
    private String baseString;

    @FCParameter()
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
