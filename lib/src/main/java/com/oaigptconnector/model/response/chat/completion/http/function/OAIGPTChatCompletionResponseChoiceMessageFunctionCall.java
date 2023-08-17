package com.oaigptconnector.model.response.chat.completion.http.function;

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


    @Override
    public String toString() {
        return "OAIGPTChatCompletionResponseChoiceMessageFunctionCall{" +
                "name='" + name + '\'' +
                ", arguments='" + arguments + '\'' +
                '}';
    }

}
