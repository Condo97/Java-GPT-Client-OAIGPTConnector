package com.oaigptconnector.model;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

public class FCTypeFactory {

    public static FCTypes get(Type type) {
        if (type == Integer.class || type == int.class)
            return FCTypes.INTEGER;
        if (type == Double.class || type == double.class || type == Float.class || type == float.class || type == Number.class)
            return FCTypes.NUMBER;
        if (type == Boolean.class || type == boolean.class)
            return FCTypes.BOOLEAN;
        if (type == String.class)
            return FCTypes.STRING;
        if (type instanceof ParameterizedType)
            if (((ParameterizedType)type).getRawType() == List.class)
                return FCTypes.ARRAY;

        return FCTypes.OBJECT;
    }

}
