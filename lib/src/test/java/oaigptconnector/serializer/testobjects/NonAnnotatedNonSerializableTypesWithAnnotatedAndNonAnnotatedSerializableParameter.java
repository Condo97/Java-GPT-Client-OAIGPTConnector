package oaigptconnector.serializer.testobjects;

import com.oaigptconnector.model.JSONSchemaParameter;
import com.oaigptconnector.model.JSONSchema;

@JSONSchema(name = "Non_Annotated_Non_Serializable_Types_With_Annotated_And_Non_Annotated_Serializable_Parameter")
public class NonAnnotatedNonSerializableTypesWithAnnotatedAndNonAnnotatedSerializableParameter {

    @JSONSchemaParameter()
    private String serializableString;

    private String nonSerializedString;

    private Object nonSerializedObject;

    public NonAnnotatedNonSerializableTypesWithAnnotatedAndNonAnnotatedSerializableParameter() {

    }

    public NonAnnotatedNonSerializableTypesWithAnnotatedAndNonAnnotatedSerializableParameter(String serializableString, String nonSerializedString, Object nonSerializedObject) {
        this.serializableString = serializableString;
        this.nonSerializedString = nonSerializedString;
        this.nonSerializedObject = nonSerializedObject;
    }

    public String getSerializableString() {
        return serializableString;
    }

    public String getNonSerializedString() {
        return nonSerializedString;
    }

    public Object getNonSerializedObject() {
        return nonSerializedObject;
    }

}
