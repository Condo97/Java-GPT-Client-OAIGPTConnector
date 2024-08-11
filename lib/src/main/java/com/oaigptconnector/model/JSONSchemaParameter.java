package com.oaigptconnector.model;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface JSONSchemaParameter {

    String name() default "";
    String description() default "";
    boolean required() default true;
    String[] stringEnumValues() default {};

}
