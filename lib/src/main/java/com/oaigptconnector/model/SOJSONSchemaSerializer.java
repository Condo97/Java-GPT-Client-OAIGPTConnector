package com.oaigptconnector.model;

import com.oaigptconnector.model.jsonschema.IJSONSchemaObject;
import com.oaigptconnector.model.jsonschema.JSONSchemaObject;
import com.oaigptconnector.model.jsonschema.ifcbase.FCBase;
import com.oaigptconnector.model.jsonschema.isobase.SOBase;

import java.util.Map;

public class SOJSONSchemaSerializer extends JSONSchemaSerializer {

    // Converts to JSON from structured output class TODO: Tests

    /***
     * Converts a class annotated with FunctionCall and FCParameters into a FCBase object in the proper format for a GPT FunctionCall request
     *
     * @param soClass - The annotated class to serialize
     * @return - The serialized FCBase, ready for the function call
     * @throws OAISerializerException - If no FunctionCall annotation or no FCParameters at all found
     */
    public static SOBase objectify(Class<?> soClass) throws OAISerializerException {
        // Ensure soClass has FunctionCall annotation, otherwise throw OAISerializerException
        if (!soClass.isAnnotationPresent(JSONSchema.class))
            throw new OAISerializerException("FunctionCall annotation not present in class");

        // Get base object description, function name, and function description from FunctionCall annotation
        String baseObjectDescription = soClass.getAnnotation(JSONSchema.class).baseObjectDescription();
        String functionName = soClass.getAnnotation(JSONSchema.class).name();
        String functionDescription = soClass.getAnnotation(JSONSchema.class).functionDescription();
        Boolean additionalProperties = soClass.getAnnotation(JSONSchema.class).additionalProperties().getValue();
        Boolean strict = soClass.getAnnotation(JSONSchema.class).strict().getValue();

        // First, create schema FCObject with description from annotation, properties from getObjectProperties, and required with properties from getRequiredObjectProperties.. Note that any empty fields will not be included in the final JSON as per the JsonInclude NON_EMPTY annotation in the IFCObject and IFCBase interfaces, and since the FunctionCall annotation interface defaults to empty fields and not null, this should work properly :)
        Map<String, IJSONSchemaObject> objectProperties = mapObjectProperties(soClass, strict != null && strict);

        // Ensure there are object properties, otherwise throw OAISerializerException
        if (objectProperties == null || objectProperties.isEmpty())
            throw new OAISerializerException("No function call properties found to be serialized");

        // Build FCObject schema
        JSONSchemaObject schema = new JSONSchemaObject(
                strict != null && strict ? Boolean.FALSE : additionalProperties, // False if strict otherwise additionalProperties
                baseObjectDescription,
                objectProperties,
                getRequiredProperties(
                        soClass,
                        strict != null && strict /* If strict all properties are required TODO: If strict is null this will still work right */)
        );

        // After all that is assembled, create FCBase with name from annotation, description from annotation, and schema as FCObject
        SOBase base = new SOBase(
                functionName,
                functionDescription,
                schema,
                strict
        );

        return base;
    }

}
