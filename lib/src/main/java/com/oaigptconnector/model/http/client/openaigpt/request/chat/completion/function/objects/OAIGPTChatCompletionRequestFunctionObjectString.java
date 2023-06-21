package com.oaigptconnector.model.http.client.openaigpt.request.chat.completion.function.objects;

public class OAIGPTChatCompletionRequestFunctionObjectString implements OAIGPTChatCompletionRequestFunctionObject {

    private final String type = "string";
    private String description;

    public OAIGPTChatCompletionRequestFunctionObjectString() {

    }

    public OAIGPTChatCompletionRequestFunctionObjectString(String description) {
        this.description = description;
    }

    @Override
    public String getType() {
        return type;
    }

}
