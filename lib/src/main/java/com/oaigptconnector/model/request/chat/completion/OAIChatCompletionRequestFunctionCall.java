package com.oaigptconnector.model.request.chat.completion;

public class OAIChatCompletionRequestFunctionCall {

    private String name;

    public OAIChatCompletionRequestFunctionCall() {

    }

    public OAIChatCompletionRequestFunctionCall(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
