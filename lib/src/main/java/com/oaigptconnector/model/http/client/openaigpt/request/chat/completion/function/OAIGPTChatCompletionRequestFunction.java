package com.oaigptconnector.model.http.client.openaigpt.request.chat.completion.function;

import com.oaigptconnector.model.http.client.openaigpt.request.chat.completion.function.objects.OAIGPTChatCompletionRequestFunctionObject;

public class OAIGPTChatCompletionRequestFunction {

    private String name;
    private String description;
    private OAIGPTChatCompletionRequestFunctionObject parameters;

    public OAIGPTChatCompletionRequestFunction() {

    }

    public OAIGPTChatCompletionRequestFunction(String name, String description, OAIGPTChatCompletionRequestFunctionObject parameters) {
        this.name = name;
        this.description = description;
        this.parameters = parameters;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public OAIGPTChatCompletionRequestFunctionObject getParameters() {
        return parameters;
    }

}
