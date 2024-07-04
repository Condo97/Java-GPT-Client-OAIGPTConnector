package com.oaigptconnector.model.request.chat.completion;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonValue;
public enum CompletionRole {

    SYSTEM("system"),
    USER("user"),
    ASSISTANT("assistant");

    private String string;

    CompletionRole(String string) {
        this.string = string;
    }

    @JsonSetter
    public static CompletionRole fromString(@JsonProperty("role") String string) {
        CompletionRole[] values = CompletionRole.values();
        for (CompletionRole value: values) {
            if (value.string.equals(string))
                return value;
        }

        throw new IllegalArgumentException("Could not find Completion Role from String");
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
