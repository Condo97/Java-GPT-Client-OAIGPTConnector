package com.oaigptconnector.model;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface FCParameter {

    String name() default "";
    String description() default "";
    boolean required() default true;
    String[] stringEnumValues() default {};

}
