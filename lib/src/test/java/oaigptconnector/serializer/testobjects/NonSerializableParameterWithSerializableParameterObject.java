package oaigptconnector.serializer.testobjects;

import com.oaigptconnector.model.JSONSchemaParameter;
import com.oaigptconnector.model.JSONSchema;

@JSONSchema(name = "Non_Serializable_Parameter_With_Serializable_Parameter")
public class NonSerializableParameterWithSerializableParameterObject {

    @JSONSchemaParameter()
    private Object nonSerializableObject;

    @JSONSchemaParameter()
    private String serializableString;

    @JSONSchemaParameter()
    private Double nonSerializableDouble;

    @JSONSchemaParameter()
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
