package com.oaigptconnector.model.request.chat.completion.function;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
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


    @Override
    public String toString() {
        return "OAIGPTChatCompletionRequestFunctionCall{" +
                "name='" + name + '\'' +
                '}';
    }

}
