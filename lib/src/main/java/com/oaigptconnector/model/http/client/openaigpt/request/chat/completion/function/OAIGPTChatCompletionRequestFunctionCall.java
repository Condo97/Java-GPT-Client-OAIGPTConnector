package com.oaigptconnector.model.http.client.openaigpt.request.chat.completion.function;

public class OAIGPTChatCompletionRequestFunctionCall {

    private String name;

    public OAIGPTChatCompletionRequestFunctionCall() {

    }

    public OAIGPTChatCompletionRequestFunctionCall(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
