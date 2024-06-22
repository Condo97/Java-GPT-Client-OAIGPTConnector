package com.oaigptconnector.model.request.chat.completion;

import com.fasterxml.jackson.annotation.JsonValue;

public enum OAIChatCompletionRequestToolType {

    FUNCTION("function");

    private String type;

    OAIChatCompletionRequestToolType(String type) {
        this.type = type;
    }

    @JsonValue
    public String getType() {
        return type;
    }

}
