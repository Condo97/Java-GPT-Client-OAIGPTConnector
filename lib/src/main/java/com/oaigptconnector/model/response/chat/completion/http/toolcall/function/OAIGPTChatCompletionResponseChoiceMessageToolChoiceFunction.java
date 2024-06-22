package com.oaigptconnector.model.response.chat.completion.http.toolcall.function;

public class OAIGPTChatCompletionResponseChoiceMessageToolChoiceFunction {

    private String name;
    private String arguments;

    public OAIGPTChatCompletionResponseChoiceMessageToolChoiceFunction() {

    }

    public OAIGPTChatCompletionResponseChoiceMessageToolChoiceFunction(String name, String arguments) {
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
