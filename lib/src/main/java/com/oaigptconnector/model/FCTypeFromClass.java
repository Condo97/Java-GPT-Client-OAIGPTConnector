package com.oaigptconnector.model;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

public class FCTypeFromClass {

    public static FCTypes getFCType(Type type) {
        if (type == Integer.class || type == int.class)
            return FCTypes.INTEGER;
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
