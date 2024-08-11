package com.oaigptconnector.model;

import com.oaigptconnector.model.jsonschema.IJSONSchemaObject;
import com.oaigptconnector.model.jsonschema.JSONSchemaObject;
import com.oaigptconnector.model.jsonschema.ifcbase.FCBase;

import java.util.Map;

public class FCJSONSchemaSerializer extends JSONSchemaSerializer {

    // Converts to JSON from function call class

    /***
     * Converts a class annotated with FunctionCall and FCParameters into a FCBase object in the proper format for a GPT FunctionCall request
     *
     * @param fcClass - The annotated class to serialize
     * @return - The serialized FCBase, ready for the function call
     * @throws OAISerializerException - If no FunctionCall annotation or no FCParameters at all found
     */
    public static FCBase objectify(Class<?> fcClass) throws OAISerializerException {
        // Ensure fcClass has FunctionCall annotation, otherwise throw OAISerializerException
        if (!fcClass.isAnnotationPresent(JSONSchema.class))
            throw new OAISerializerException("FunctionCall annotation not present in class");

        // Get base object description, function name, and function description from FunctionCall annotation
        String baseObjectDescription = fcClass.getAnnotation(JSONSchema.class).baseObjectDescription();
        String functionName = fcClass.getAnnotation(JSONSchema.class).name();
        String functionDescription = fcClass.getAnnotation(JSONSchema.class).functionDescription();
        Boolean additionalProperties = fcClass.getAnnotation(JSONSchema.class).additionalProperties().getValue();
        Boolean strict = fcClass.getAnnotation(JSONSchema.class).strict().getValue();

        // First, create parameters FCObject with description from annotation, properties from getObjectProperties, and required with properties from getRequiredObjectProperties.. Note that any empty fields will not be included in the final JSON as per the JsonInclude NON_EMPTY annotation in the IFCObject and IFCBase interfaces, and since the FunctionCall annotation interface defaults to empty fields and not null, this should work properly :)
        Map<String, IJSONSchemaObject> objectProperties = mapObjectProperties(fcClass, strict != null && strict);

        // Ensure there are object properties, otherwise throw OAISerializerException
        if (objectProperties == null || objectProperties.isEmpty())
            throw new OAISerializerException("No function call properties found to be serialized");

        // Build FCObject parameters
        JSONSchemaObject parameters = new JSONSchemaObject(
                strict != null && strict ? Boolean.FALSE : additionalProperties, // False if strict otherwise additionalProperties
                baseObjectDescription,
                objectProperties,
                getRequiredProperties(
                        fcClass,
                        strict != null && strict /* If strict all properties are required TODO: If strict is null this will still work right */)
        );

        // After all that is assembled, create FCBase with name from annotation, description from annotation, and parameters as FCObject
        FCBase base = new FCBase(
                functionName,
                functionDescription,
                parameters,
                strict
        );

        return base;
    }

}
