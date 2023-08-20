package com.oaigptconnector.model;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface FunctionCall {

    String name();
    String functionDescription() default "";
    String baseObjectDescription() default "";

}
