package com.oaigptconnector.model.request.chat.completion.function.objects;

public class OAIFunctionObjectInteger implements OAIFunctionObject {

    public final String type = "integer";
    private String description;

    public OAIFunctionObjectInteger() {

    }

    public OAIFunctionObjectInteger(String description) {
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
        return "OAIGPTChatCompletionRequestFunctionObjectInteger{" +
                "type='" + type + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

}
