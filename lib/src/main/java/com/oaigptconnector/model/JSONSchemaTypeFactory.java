package com.oaigptconnector.model;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

public class JSONSchemaTypeFactory {

    public static JSONSchemaTypes get(Type type) {
        if (type == Integer.class || type == int.class)
            return JSONSchemaTypes.INTEGER;
        if (type == Double.class || type == double.class || type == Float.class || type == float.class || type == Number.class)
            return JSONSchemaTypes.NUMBER;
        if (type == Boolean.class || type == boolean.class)
            return JSONSchemaTypes.BOOLEAN;
        if (type == String.class)
            return JSONSchemaTypes.STRING;
        if (type instanceof ParameterizedType)
            if (((ParameterizedType)type).getRawType() == List.class)
                return JSONSchemaTypes.ARRAY;

        return JSONSchemaTypes.OBJECT;
    }

}
