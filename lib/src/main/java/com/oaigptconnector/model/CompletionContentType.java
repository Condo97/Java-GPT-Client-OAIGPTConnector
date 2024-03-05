package com.oaigptconnector.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

public enum CompletionContentType {

    TEXT("text"),
    IMAGE("image"),
    IMAGE_URL("image_url");

    private String string;

    CompletionContentType(String string) {
        this.string = string;
    }

    @JsonCreator
    public static CompletionContentType fromString(@JsonProperty("type") String string) {
        CompletionContentType[] values = CompletionContentType.values();
        for (CompletionContentType value: values) {
            if (value.string.equals(string))
                return value;
        }

        throw new IllegalArgumentException("Could not find Completion Content Type from String");
    }

    @JsonValue
    public String stringValue() {
        return string;
    }

    @Override
    public String toString() {
        return string;
    }
}
