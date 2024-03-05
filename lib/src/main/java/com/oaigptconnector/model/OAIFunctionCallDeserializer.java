package com.oaigptconnector.model;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class OAIFunctionCallDeserializer {

    public static <T> T deserialize(String jsonString, Class<T> fcClass) throws OAIDeserializerException {
        try {
            return deserialize(new ObjectMapper().readValue(jsonString, Map.class), fcClass);
        } catch (IOException e) {
            throw new OAIDeserializerException("Cannot convert provided jsonString to JsonNode!", e);
        }
    }

    public static <T> T deserialize(Map<?, ?> json, Class<T> fcClass) throws OAIDeserializerException {
        // Instantiate fcObject from fcClass
        T fcObject = null;
        try {
            fcObject = fcClass.getDeclaredConstructor().newInstance();
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new OAIDeserializerException("Error creating new instance of target class " + fcClass, e);
        }

        // Loop through fcObject fields using annotation name value if provided and field name as keys for the json, setting with values from the json
        for (Field field: fcObject.getClass().getDeclaredFields()) {
            // Ensure FCParameter annotation is present, otherwise continue
            if (!field.isAnnotationPresent(FCParameter.class))
                continue;

            // Set field to be accessible
            field.setAccessible(true);

            // If FCParameter annotation name is not blank, and it will never be null, and if the json value for the key is not null, set field value to json value and continue, catching unchecked IllegalArgumentException (to avoid runtime exception  and checked IllegalAccessException and throwing OAIDeserializerException
            String fcParameterAnnotationName = field.getAnnotation(FCParameter.class).name();
            if (!fcParameterAnnotationName.isBlank()) {
                Object jsonValue = json.get(fcParameterAnnotationName);
                if (jsonValue != null) {
                    setField(field, fcObject, jsonValue);

                    continue;
                }
            }

            // Using the field name as the json key, if the value for that key is not null, set field value to json value and continue
            String fieldName = field.getName();
            Object jsonValue = json.get(fieldName);
            if (jsonValue != null) {
                setField(field, fcObject, jsonValue);

                continue;
            }
        }

        return fcObject;
    }

    private static void setField(Field field, Object object, Object value) throws OAIDeserializerException {
        // Set field to be accessible
        field.setAccessible(true);

        try {
            try {
                // Custom Object List HANDLING - If field and value are List and field List parameter is not LinkedHashMap but value List parameter is LinkedHashMap, create a List, loop through value List objects deserializing each with the field List parameter as the class
                if ((field.getType() == List.class && value instanceof List)) {
                    // Due to Java type erasure, the parameterized type of value as a List is not available at runtime, so the type of the first object needs to be used instead
                    List valueAsList = (List)value;
                    if (valueAsList.size() > 0) {
                        // Get value type from first element in list
                        Class<?> valueType = valueAsList.get(0).getClass();

                        if (TypeAdapter.getFirstParameterType(field.getGenericType()) != LinkedHashMap.class && valueType == LinkedHashMap.class) {
                            // Field most likely expects a list of a custom object, so create that list by deserializing each LinkedHashMap in value list
                            List<Object> customObjectList = new ArrayList<>();
                            List valueList = (List)value;
                            Class<?> fieldParameterClass = TypeAdapter.getClass(TypeAdapter.getFirstParameterType(field.getGenericType()));

                            // Adapt valueList to customObjectList using deserialize to the fieldParameterClass
                            for (Object valueListValue: valueList) {
                                customObjectList.add(deserialize((LinkedHashMap)valueListValue, fieldParameterClass));
                            }

                            // Set value to customObjectList so it will be set by field.set :)
                            value = customObjectList;
                        }
                    }
                }

                // Try to set field
                field.set(object, value);

            } catch (IllegalArgumentException e) {
                // If field.set throws IllegalArgumentException meaning an object value mismatch, check to see if the field expects an Integer and it's trying to insert a Double, and see if it can be set after casting, otherwise throw e to have it caught by the enclosing try block TODO: It seems that Double is what ObjectMapper sets decimal numbers to pretty consistently, however this should be further tested to see if there are more cases of fixable type inconsistency :)
                if (field.getType() == Integer.class && value.getClass() == Double.class) {
                    field.set(object, Integer.valueOf((int)((Double)value).doubleValue()));
                } else if (value.getClass() == LinkedHashMap.class) {
                    field.set(object, deserialize((LinkedHashMap)value, field.getType()));
                } else {
                    throw e;
                }
            }
        } catch (IllegalArgumentException e) {
            throw new OAIDeserializerException("Type mismatch for field " + field + " and json value " + value + (value != null ? " of type " + value.getClass() : "") + "!", e);
        } catch (IllegalAccessException e) {
            throw new OAIDeserializerException("Illegal access for field... this should never happen!", e);
        }
    }

}
