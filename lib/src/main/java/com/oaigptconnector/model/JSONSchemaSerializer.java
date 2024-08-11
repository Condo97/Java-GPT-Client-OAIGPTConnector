package com.oaigptconnector.model;

import com.oaigptconnector.model.jsonschema.*;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JSONSchemaSerializer {

    /***
     * Gets the function name from the FunctionCall annotation in a FunctionCall annotated class
     *
     * @param fcClass - The annotated class to get the FunctionCall annotation name value
     * @return - The FunctionCall annotation name value
     * @throws OAISerializerException - If there is no FunctionCall annotation found
     */
    public static String getFunctionName(Class<?> fcClass) throws OAISerializerException {
        // Ensure fcClass has FunctionCall annotation, otherwise throw OAISerializerException
        if (!fcClass.isAnnotationPresent(JSONSchema.class))
            throw new OAISerializerException("FunctionCall annotation not present in class");

        // Get and return functionName
        return fcClass.getAnnotation(JSONSchema.class).name();
    }

    /* Private Methods */

    /***
     * Maps object properties for a FunctionCall annotated class,
     *
     *
     * @param dbClass
     * @return
     * @throws OAISerializerException
     */
    static Map<String, IJSONSchemaObject> mapObjectProperties(Class dbClass, boolean strictParentRequireAllObjectPropertiesAndFalseAdditionalProperties) throws OAISerializerException {
        // Create object properties map
        Map<String, IJSONSchemaObject> op = new HashMap<>();

        // Loop through each field, adding name and corresponding FCObject to op map
        for (Field field: dbClass.getDeclaredFields()) {
            // Ensure field annotation is present, otherwise continue
            if (!field.isAnnotationPresent(JSONSchemaParameter.class))
                continue;

            // Get name, IFCObject, and stringEnumValues from field
            String name = getName(field);
            IJSONSchemaObject IJSONSchemaObject = getIFCObject(field, strictParentRequireAllObjectPropertiesAndFalseAdditionalProperties);

            // If ifcObject is null, continue
            if (IJSONSchemaObject == null)
                continue;

            // Put name as key and IFCObject for field as value in op
            op.put(
                    name,
                    IJSONSchemaObject
            );
        }

        // Return object properties map
        return op;
    }

    static String getName(Field field) throws OAISerializerException {
        // If FCParameter is not present, throw OAISerializerException, the annotation should always be present in the getName function.. in the current logic this means it is checked in the field for loop in mapObjectProperties where it continues instead of throwing so that all the annotated fields will still be converted to the map and the non annotated fields will simply be not included in the map
        if (!field.isAnnotationPresent(JSONSchemaParameter.class))
            throw new OAISerializerException("FCParameter annotation not found for field " + field);

        // If the name is not blank, and it will never be null, return the name
        String name = field.getAnnotation(JSONSchemaParameter.class).name();
        if (!name.isBlank())
            return name;

        // Return the name of the field otherwise
        return field.getName();
    }

    static IJSONSchemaObject getIFCObject(Field field, Boolean strictParentRequireAllObjectPropertiesAndFalseAdditionalProperties) throws OAISerializerException {
        // Ensure FCParameter is present, otherwise throw OAISerializerException
        if (!field.isAnnotationPresent(JSONSchemaParameter.class))
            throw new OAISerializerException("FCParameter annotation not present in field " + field);

        // Get description, field type, and stringEnumValues and return getIFCObject
        String description = field.getAnnotation(JSONSchemaParameter.class).description();
        Type genericType = field.getGenericType();
        String[] stringEnumValues = field.getAnnotation(JSONSchemaParameter.class).stringEnumValues();

        return getIFCObject(genericType, description, stringEnumValues, strictParentRequireAllObjectPropertiesAndFalseAdditionalProperties);
    }

    static IJSONSchemaObject getIFCObject(Type genericType, String description, String[] stringEnumValues, boolean strictParentRequireAllObjectPropertiesAndFalseAdditionalProperties) throws OAISerializerException {
        // Get FCType from type
        JSONSchemaTypes fcType = JSONSchemaTypeFactory.get(genericType);
        return switch(fcType) {
            case INTEGER -> new JSONSchemaInteger(description);
            case NUMBER -> new JSONSchemaNumber(description);
            case BOOLEAN -> new JSONSchemaBoolean(description);
            case STRING -> new JSONSchemaString(description, stringEnumValues == null || stringEnumValues.length == 0 ? null : stringEnumValues);
            case ARRAY -> new JSONSchemaArray(
                    description,
                    getIFCObject(TypeAdapter.getFirstParameterType(genericType), null, null, strictParentRequireAllObjectPropertiesAndFalseAdditionalProperties)
            );
            case OBJECT -> {
                // Get object properties, throw OAISerializerException if null since there is a FCParameter annotation on a non-serializable type, otherwise yield FCObject with object properties
                Map<String, IJSONSchemaObject> objectProperties = mapObjectProperties(TypeAdapter.getClass(genericType), strictParentRequireAllObjectPropertiesAndFalseAdditionalProperties);
                if (objectProperties == null || objectProperties.isEmpty())
                    throw new OAISerializerException("FCParameter on non-serializable type " + genericType);

                yield new JSONSchemaObject(
                        strictParentRequireAllObjectPropertiesAndFalseAdditionalProperties ? Boolean.FALSE : null, // False if strict parent for it and all sub objects, otherwise null
                        description,
                        objectProperties,
                        getRequiredProperties(
                                TypeAdapter.getClass(genericType),
                                strictParentRequireAllObjectPropertiesAndFalseAdditionalProperties/* For all properties required true if strict parent for it and all sub objects, otherwise false TODO: If strict is null this will still work right */)
                );
            }
        };
    }

    static List<String> getRequiredProperties(Class dbClass, boolean requireAll) throws OAISerializerException {
        // Create list for required properties
        List<String> requiredProperties = new ArrayList<>();

        // Loop through each field in dbClass, and if the FCParameter annotation is exists and required is true, get and add name to requiredProperties
        for (Field field: dbClass.getDeclaredFields())
            if (field.isAnnotationPresent(JSONSchemaParameter.class))
                if (field.getAnnotation(JSONSchemaParameter.class).required() || requireAll)
                    requiredProperties.add(getName(field));

        // Return required properties
        return requiredProperties;
    }

}
