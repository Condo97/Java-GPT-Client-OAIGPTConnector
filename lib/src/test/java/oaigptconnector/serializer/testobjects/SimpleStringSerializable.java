package oaigptconnector.serializer.testobjects;

import com.oaigptconnector.model.FCParameter;
import com.oaigptconnector.model.FunctionCall;

@FunctionCall(name = "Simple_String_Serializable")
public class SimpleStringSerializable {

    @FCParameter
    private String firstString;

    @FCParameter(name = "second_string_FCParameter_name")
    private String secondString;

    @FCParameter(description = "third string FCParameter description :)")
    private String thirdString;

    @FCParameter(name = "fourth_string_FCParameter_name", description = "fourth string FCParameter description!")
    private String fourthString;

    private String fifthStringNoParameter;

    public SimpleStringSerializable() {

    }

    public SimpleStringSerializable(String firstString, String secondString, String thirdString, String fourthString, String fifthStringNoParameter) {
        this.firstString = firstString;
        this.secondString = secondString;
        this.thirdString = thirdString;
        this.fourthString = fourthString;
        this.fifthStringNoParameter = fifthStringNoParameter;
    }

    public String getFirstString() {
        return firstString;
    }

    public String getSecondString() {
        return secondString;
    }

    public String getThirdString() {
        return thirdString;
    }

    public String getFourthString() {
        return fourthString;
    }

    public String getFifthStringNoParameter() {
        return fifthStringNoParameter;
    }

}
