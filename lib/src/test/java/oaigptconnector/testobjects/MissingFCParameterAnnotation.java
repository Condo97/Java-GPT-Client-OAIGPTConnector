package oaigptconnector.testobjects;

import com.oaigptconnector.model.FunctionCall;

@FunctionCall(name = "Missing_FC_Parameter_Annotations")
public class MissingFCParameterAnnotation {

    private String baseString;
    private Integer baseInteger;

    public MissingFCParameterAnnotation() {

    }

    public MissingFCParameterAnnotation(String baseString, Integer baseInteger) {
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
