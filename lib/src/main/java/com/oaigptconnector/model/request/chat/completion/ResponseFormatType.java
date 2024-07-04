package com.oaigptconnector.model.request.chat.completion;

import com.fasterxml.jackson.annotation.*;

public enum ResponseFormatType {

    TEXT("text"),
    JSON_OBJECT("json_object");

    private String string;

    ResponseFormatType(String string) {
        this.string = string;
    }

    @JsonSetter
    public static ResponseFormatType fromString(String string) {
        // Null check or TEXT as default
        if (string == null) {
            return TEXT;
        }

        // Search for string from enums values' strings
        ResponseFormatType[] values = ResponseFormatType.values();
        for (ResponseFormatType value: values) {
            if (value.string.equals(string))
                return value;
        }

        // Default to TEXT
        return TEXT;
    }

    @JsonValue
    public String getString() {
        return string;
    }

}
