package oaigptconnector.serializer.testobjects;

import com.oaigptconnector.model.JSONSchemaParameter;
import com.oaigptconnector.model.JSONSchema;

@JSONSchema(name = "Non_Serializable_Parameter")
public class NonSerializableParameter {

    @JSONSchemaParameter()
    private Object nonSerializableObject;

    @JSONSchemaParameter()
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
