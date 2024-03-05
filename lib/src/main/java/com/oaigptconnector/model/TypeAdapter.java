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

    public static Type getFirstParameterType(Type genericType) {
        // If genericType is ParameterizedType, get and return the first parameter type
        if (genericType instanceof ParameterizedType) {
            // Cast to ParameterizedType
            ParameterizedType parameterizedType = (ParameterizedType)genericType;

            // Get actual type arguments
            Type[] typeArguments = parameterizedType.getActualTypeArguments();

            // If typeArguments length is less than 1, return null, otherwise return first typeArgument
            if (typeArguments.length < 1)
                return null;

            return typeArguments[0];
        }

        return null;
    }

}
