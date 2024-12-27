package com.oaigptconnector.model.request.chat.completion.content;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonValue;

public enum InputImageDetail {

    LOW("low"),
    HIGH("high"),
    AUTO("auto");

    private String string;

    InputImageDetail(String string) {
        this.string = string;
    }

    @JsonSetter
//    public static InputImageDetail fromString(@JsonProperty("detail") String string) {
    public static InputImageDetail fromString(String string) {
        // Null check though it doesn't matter in this case but still good practice and I'm nervous :)
        if (string == null) {
            return InputImageDetail.LOW; // TODO: Test and ensure this should not default to Auto
        }

        // Search for parameter string from enum values' strings returning enum value when found
        InputImageDetail[] values = InputImageDetail.values();
        for (InputImageDetail value: values) {
            if (value.string.equals(string))
                return value;
        }

        // Default to low quality if not found
        return InputImageDetail.LOW;
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
