package com.oaigptconnector.model.request.chat.completion.function.objects;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class OAIFunctionObjectString implements OAIFunctionObject {

    private final String type = "string";
    private String description;

    public OAIFunctionObjectString() {

    }

    public OAIFunctionObjectString(String description) {
        this.description = description;
    }

    @Override
    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "OAIGPTChatCompletionRequestFunctionObjectString{" +
                "type='" + type + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

}
