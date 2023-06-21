package com.oaigptconnector.model.http.client.openaigpt.response.chat.completion.http.function;

public class OAIGPTChatCompletionResponseChoiceMessageFunctionCall {

    private String name;
    private String arguments;

    public OAIGPTChatCompletionResponseChoiceMessageFunctionCall() {

    }

    public OAIGPTChatCompletionResponseChoiceMessageFunctionCall(String name, String arguments) {
        this.name = name;
        this.arguments = arguments;
    }

    public String getName() {
        return name;
    }

    public String getArguments() {
        return arguments;
    }

}
