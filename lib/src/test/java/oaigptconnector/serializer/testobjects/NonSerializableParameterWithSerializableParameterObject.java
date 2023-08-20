package oaigptconnector.serializer.testobjects;

import com.oaigptconnector.model.FCParameter;
import com.oaigptconnector.model.FunctionCall;

@FunctionCall(name = "Non_Serializable_Parameter_With_Serializable_Parameter")
public class NonSerializableParameterWithSerializableParameterObject {

    @FCParameter()
    private Object nonSerializableObject;

    @FCParameter()
    private String serializableString;

    @FCParameter()
    private Double nonSerializableDouble;

    @FCParameter()
    private Integer serializableInteger;

    public NonSerializableParameterWithSerializableParameterObject() {

    }

    public NonSerializableParameterWithSerializableParameterObject(Object nonSerializableObject, String serializableString, Double nonSerializableDouble, Integer serializableInteger) {
        this.nonSerializableObject = nonSerializableObject;
        this.serializableString = serializableString;
        this.nonSerializableDouble = nonSerializableDouble;
        this.serializableInteger = serializableInteger;
    }

    public Object getNonSerializableObject() {
        return nonSerializableObject;
    }

    public String getSerializableString() {
        return serializableString;
    }

    public Double getNonSerializableDouble() {
        return nonSerializableDouble;
    }

    public Integer getSerializableInteger() {
        return serializableInteger;
    }

}
