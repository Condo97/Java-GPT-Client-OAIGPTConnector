package com.oaigptconnector.model;

import com.oaigptconnector.model.fcobjects.ifcbase.FCBase;
import com.oaigptconnector.model.fcobjects.ifcobject.*;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OAIFunctionCallSerializer {

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
        if (!fcClass.isAnnotationPresent(FunctionCall.class))
            throw new OAISerializerException("FunctionCall annotation not present in class");

        // Get base object description, function name, and function description from FunctionCall annotation
        String baseObjectDescription = fcClass.getAnnotation(FunctionCall.class).baseObjectDescription();
        String functionName = fcClass.getAnnotation(FunctionCall.class).name();
        String functionDescription = fcClass.getAnnotation(FunctionCall.class).functionDescription();

        // First, create parameters FCObject with description from annotation, properties from getObjectProperties, and required with properties from getRequiredObjectProperties.. Note that any empty fields will not be included in the final JSON as per the JsonInclude NON_EMPTY annotation in the IFCObject and IFCBase interfaces, and since the FunctionCall annotation interface defaults to empty fields and not null, this should work properly :)
        Map<String, IFCObject> objectProperties = mapObjectProperties(fcClass);

        // Ensure there are object properties, otherwise throw OAISerializerException
        if (objectProperties == null || objectProperties.isEmpty())
            throw new OAISerializerException("No function call properties found to be serialized");

        // Build FCObject parameters
        FCObject parameters = new FCObject(
                baseObjectDescription,
                objectProperties,
                getRequiredProperties(fcClass)
        );


        // After all that is assembled, create FCBase with name from annotation, description from annotation, and parameters as FCObject
        FCBase base = new FCBase(
                functionName,
                functionDescription,
                parameters
        );

        return base;
    }

    /***
     * Gets the function name from the FunctionCall annotation in a FunctionCall annotated class
     *
     * @param fcClass - The annotated class to get the FunctionCall annotation name value
     * @return - The FunctionCall annotation name value
     * @throws OAISerializerException - If there is no FunctionCall annotation found
     */
    public static String getFunctionName(Class<?> fcClass) throws OAISerializerException {
        // Ensure fcClass has FunctionCall annotation, otherwise throw OAISerializerException
        if (!fcClass.isAnnotationPresent(FunctionCall.class))
            throw new OAISerializerException("FunctionCall annotation not present in class");

        // Get and return functionName
        return fcClass.getAnnotation(FunctionCall.class).name();
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
    private static Map<String, IFCObject> mapObjectProperties(Class dbClass) throws OAISerializerException {
        // Create object properties map
        Map<String, IFCObject> op = new HashMap<>();

        // Loop through each field, adding name and corresponding FCObject to op map
        for (Field field: dbClass.getDeclaredFields()) {
            // Ensure field annotation is present, otherwise continue
            if (!field.isAnnotationPresent(FCParameter.class))
                continue;

            // Get name, IFCObject, and stringEnumValues from field
            String name = getName(field);
            IFCObject ifcObject = getIFCObject(field);

            // If ifcObject is null, continue
            if (ifcObject == null)
                continue;

            // Put name as key and IFCObject for field as value in op
            op.put(
                    name,
                    ifcObject
            );
        }

        // Return object properties map
        return op;
    }

    private static String getName(Field field) throws OAISerializerException {
        // If FCParameter is not present, throw OAISerializerException, the annotation should always be present in the getName function.. in the current logic this means it is checked in the field for loop in mapObjectProperties where it continues instead of throwing so that all the annotated fields will still be converted to the map and the non annotated fields will simply be not included in the map
        if (!field.isAnnotationPresent(FCParameter.class))
            throw new OAISerializerException("FCParameter annotation not found for field " + field);

        // If the name is not blank, and it will never be null, return the name
        String name = field.getAnnotation(FCParameter.class).name();
        if (!name.isBlank())
            return name;

        // Return the name of the field otherwise
        return field.getName();
    }

    private static IFCObject getIFCObject(Field field) throws OAISerializerException {
        // Ensure FCParameter is present, otherwise throw OAISerializerException
        if (!field.isAnnotationPresent(FCParameter.class))
            throw new OAISerializerException("FCParameter annotation not present in field " + field);

        // Get description, field type, and stringEnumValues and return getIFCObject
        String description = field.getAnnotation(FCParameter.class).description();
        Type genericType = field.getGenericType();
        String[] stringEnumValues = field.getAnnotation(FCParameter.class).stringEnumValues();

        return getIFCObject(genericType, description, stringEnumValues);
    }

    private static IFCObject getIFCObject(Type genericType, String description, String[] stringEnumValues) throws OAISerializerException {
        // Get FCType from type
        FCTypes fcType = FCTypeFactory.get(genericType);
        return switch(fcType) {
            case INTEGER -> new FCInteger(description);
            case NUMBER -> new FCNumber(description);
            case BOOLEAN -> new FCBoolean(description);
            case STRING -> new FCString(description, stringEnumValues == null || stringEnumValues.length == 0 ? null : stringEnumValues);
            case ARRAY -> new FCArray(
                    description,
                    getIFCObject(TypeAdapter.getFirstParameterType(genericType), null, null)
            );
            case OBJECT -> {
                // Get object properties, throw OAISerializerException if null since there is a FCParameter annotation on a non-serializable type, otherwise yield FCObject with object properties
                Map<String, IFCObject> objectProperties = mapObjectProperties(TypeAdapter.getClass(genericType));
                if (objectProperties == null || objectProperties.isEmpty())
                    throw new OAISerializerException("FCParameter on non-serializable type " + genericType);

                yield new FCObject(
                        description,
                        objectProperties,
                        getRequiredProperties(TypeAdapter.getClass(genericType))
                );
            }
        };
    }

    private static List<String> getRequiredProperties(Class dbClass) throws OAISerializerException {
        // Create list for required properties
        List<String> requiredProperties = new ArrayList<>();

        // Loop through each field in dbClass, and if the FCParameter annotation is exists and required is true, get and add name to requiredProperties
        for (Field field: dbClass.getDeclaredFields())
            if (field.isAnnotationPresent(FCParameter.class))
                if (field.getAnnotation(FCParameter.class).required())
                    requiredProperties.add(getName(field));

        // Return required properties
        return requiredProperties;
    }

}
