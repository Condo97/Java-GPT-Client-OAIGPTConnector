package com.oaigptconnector.model;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface JSONSchema {

    String name();
    String functionDescription() default "";
    String baseObjectDescription() default "";
    NullableBool additionalProperties() default NullableBool.NULL;
    NullableBool strict() default NullableBool.NULL;


    enum NullableBool {
        NULL(null),
        TRUE(true),
        FALSE(false);

        private Boolean value;

        NullableBool(Boolean value) {
            this.value = value;
        }

        public Boolean getValue() {
            return value;
        }

    }

}
