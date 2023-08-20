package oaigptconnector.serializer.testobjects;

import com.oaigptconnector.model.FCParameter;
import com.oaigptconnector.model.FunctionCall;

@FunctionCall(name = "Non_Serializable_Parameter")
public class NonSerializableParameter {

    @FCParameter()
    private Object nonSerializableObject;

    @FCParameter()
    private Double nonSerializableDouble;

    public NonSerializableParameter() {

    }

    public NonSerializableParameter(Object nonSerializableObject, Double nonSerializableDouble) {
        this.nonSerializableObject = nonSerializableObject;
        this.nonSerializableDouble = nonSerializableDouble;
    }

    public Object getNonSerializableObject() {
        return nonSerializableObject;
    }

    public Double getNonSerializableDouble() {
        return nonSerializableDouble;
    }

}
