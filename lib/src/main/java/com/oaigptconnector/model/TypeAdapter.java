package com.oaigptconnector.model;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;

public class TypeAdapter {

    public static Class<?> getClass(Type type) {
        if (type instanceof Class<?>)
            return (Class<?>)type;
        if (type instanceof ParameterizedType)
            return getClass(((ParameterizedType)type).getRawType());
        if (type instanceof WildcardType) {
            WildcardType wt = (WildcardType)type;
            Type[] upperBounds = wt.getUpperBounds();
            if (upperBounds.length > 0)
                return getClass(upperBounds[0]);

            throw new IllegalArgumentException("Wildcard has no upper bounds " + wt);
        }

        throw new IllegalArgumentException("Unsupported type " + type);
    }

}
