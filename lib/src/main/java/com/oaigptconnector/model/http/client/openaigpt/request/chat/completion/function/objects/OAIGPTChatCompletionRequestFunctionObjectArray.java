package com.oaigptconnector.model.http.client.openaigpt.request.chat.completion.function.objects;

public class OAIGPTChatCompletionRequestFunctionObjectArray implements OAIGPTChatCompletionRequestFunctionObject {

    private final String type = "array";
    private String description;
    private OAIGPTChatCompletionRequestFunctionObject items;

    public OAIGPTChatCompletionRequestFunctionObjectArray() {

    }

    public OAIGPTChatCompletionRequestFunctionObjectArray(String description, OAIGPTChatCompletionRequestFunctionObject items) {
        this.description = description;
        this.items = items;
    }

    @Override
    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public OAIGPTChatCompletionRequestFunctionObject getItems() {
        return items;
    }

}
